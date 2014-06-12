/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.JStickyNote.App;

import com.thoughtworks.xstream.XStream;
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
            String pathString = Preferences.getInstance().getSavePath();
            Path path = Paths.get(pathString);
            ArrayList<String> xmlList = new ArrayList<>();
            xmlList.add(this.toXml());
            Files.write(path, xmlList, ENCODING);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE,
                    "Error while writing file.", ex);
            throw ex;
        }
    }

    public static void loadStackFromFile() throws IOException {
        try {
            String pathString = Preferences.getInstance().getSavePath();
            Path path = Paths.get(pathString);
            List<String> xmlFileStrings = Files.readAllLines(path, ENCODING);
            StringBuilder sb = new StringBuilder();
            for (String line : xmlFileStrings) {
                sb.append(line);
            }
            PaperStack.fromXml(sb.toString());
        } catch (IOException ex) {
            LOG.log(Level.SEVERE,
                    null, ex);
            PaperStack.fromXml(null);
            throw ex;
        }
    }

    public String toXml() {
        XStream xml = new XStream();
        return xml.toXML(this);
    }

    public static void fromXml(String xmlString) {
        if (xmlString == null || xmlString.isEmpty()) {
            INSTANCE = new PaperStack();
        } else {
            XStream xml = new XStream();
            INSTANCE = (PaperStack) xml.fromXML(xmlString);
            if (INSTANCE == null) {
                INSTANCE = new PaperStack();
                LOG.warning("Failed to parse xml string. Using empty pad.");
            }
        }

    }
}
