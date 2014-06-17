/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jens
 */
public class NoteRegistry {

    private static NoteRegistry INSTANCE;

    private final Map<String, Note> registry = new HashMap<String, Note>();

    private NoteRegistry() {

    }

    public static NoteRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NoteRegistry();
        }
        return INSTANCE;
    }

    public void registerNote(Note note) {
        registry.put(note.getId(), note);
    }

    public void unregisterNote(String id) {
        registry.remove(id);
    }

    public void closeAll() {
        for (String item : registry.keySet()) {
            registry.get(item).dispose();
        }
    }

    public void saveAll() {
        for (String item : registry.keySet()) {
            registry.get(item).saveNote();
        }
    }

    public void setAllOnFront(String id) {
        for (String item : registry.keySet()) {
            registry.get(item).setState(Frame.NORMAL);
            registry.get(item).toFront();
            registry.get(item).repaint();
        }
        registry.get(id).toFront();
        registry.get(id).repaint();
    }

}
