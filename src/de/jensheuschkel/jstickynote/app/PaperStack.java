/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class PaperStack {

    private static final Logger LOG = Logger.getLogger(PaperStack.class.getName());
    final static Charset ENCODING = StandardCharsets.UTF_8;
    private static PaperStack INSTANCE;
    private final Map<String, NoteContent> notes = new HashMap<>();

    private PaperStack() {

    }

    public static PaperStack getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("create instance from xml first");
        }
        return INSTANCE;
    }

    public void addNote(NoteContent note) throws IOException {
        if (notes.containsKey(note.getId())) {
            notes.remove(note.getId());
            LOG.log(Level.INFO, "Remove note with id:{0}", note.getId());
        }
        notes.put(note.getId(), note);
        LOG.log(Level.INFO, "Add note with id:{0}", note.getId());
        saveStackToFile();
    }

    public void removeNote(String noteId) throws IOException {
        if (notes.containsKey(noteId)) {
            notes.remove(noteId);
            LOG.log(Level.INFO, "Remove note with id:{0}", noteId);
        }
        saveStackToFile();
    }

    public NoteContent getNote(String Id) {
        return notes.get(Id);
    }

    public List<NoteContent> getAllNotes() {
        ArrayList<NoteContent> retVal = new ArrayList<>();
        for (String key : notes.keySet()) {
            retVal.add(notes.get(key));
        }
        return retVal;
    }

    public void saveStackToFile() throws IOException {
        try {
            // prepare folder
            String pathString;
            if (Preferences.getInstance().isSavePath1Active()) {
                pathString = Preferences.getInstance().getSavePath1();
            } else if (Preferences.getInstance().isSavePath2Active()) {
                pathString = Preferences.getInstance().getSavePath2();
            } else if (Preferences.getInstance().isSavePath3Active()) {
                pathString = Preferences.getInstance().getSavePath3();
            } else {
                Preferences.getInstance().setSavePath1Active(true);
                pathString = Preferences.getInstance().getSavePath1();
            }
            if (!(pathString.endsWith("/") || pathString.endsWith("\\"))) {
                pathString += "/";
            }
            (new File(pathString)).mkdirs();
            // save files
//            ArrayList<String> xmlList = new ArrayList<>();
//            xmlList.add(this.toXml());
//            Files.write(path, xmlList, ENCODING);
            for (NoteContent note : notes.values()) {
                // prepare xml
                ArrayList<String> xmlLines = new ArrayList<>();
                xmlLines.add(note.toXml());
                // prepare path
                Path path = Paths.get(pathString + note.getId() + ".xml");
                // write file
                Files.write(path, xmlLines, ENCODING);
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE,
                    "Error while writing file.", ex);
            throw ex;
        }
    }

    public static void loadStackFromFile() throws IOException {
        // create new stack
        INSTANCE = new PaperStack();
        // fill stack with notes from files
        try {
            String pathString;
            if (Preferences.getInstance().isSavePath1Active()) {
                pathString = Preferences.getInstance().getSavePath1();
            } else if (Preferences.getInstance().isSavePath2Active()) {
                pathString = Preferences.getInstance().getSavePath2();
            } else if (Preferences.getInstance().isSavePath3Active()) {
                pathString = Preferences.getInstance().getSavePath3();
            } else {
                Preferences.getInstance().setSavePath1Active(true);
                pathString = Preferences.getInstance().getSavePath1();
            }
            File saveFolder = new File(pathString);

            for (File noteFile : saveFolder.listFiles()) {
                StringBuilder sb = new StringBuilder();
                Path path = Paths.get(noteFile.getAbsolutePath());
                try (Scanner scanner = new Scanner(path, ENCODING.name())) {
                    while (scanner.hasNextLine()) {
                        sb.append(scanner.nextLine());
                    }
                    scanner.close();
                }
                INSTANCE.addNote(NoteContent.fromXml(sb.toString()));
            }

//            PaperStack.fromXml(sb.toString());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE,
                    null, ex);
//            PaperStack.fromXml(null);
            throw ex;
        }
    }

//    public String toXml() {
//        XStream xml = new XStream();
//        return xml.toXML(this);
//    }
//
//    public static void fromXml(String xmlString) {
//        if (xmlString == null || xmlString.isEmpty()) {
//            INSTANCE = new PaperStack();
//        } else {
//            XStream xml = new XStream();
//            INSTANCE = (PaperStack) xml.fromXML(xmlString);
//            if (INSTANCE == null) {
//                INSTANCE = new PaperStack();
//                LOG.warning("Failed to parse xml string. Using empty pad.");
//            }
//        }
//
//    }
}
