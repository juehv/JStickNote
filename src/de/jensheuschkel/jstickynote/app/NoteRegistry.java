/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jens
 */
public class NoteRegistry {

    private static NoteRegistry INSTANCE;

    private final Map<String, Note> registry = new HashMap<>();
    private Frame iconDummy;

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

    public void setAllOnFront() {
        for (String item : registry.keySet()) {
            //  registry.get(item).setState(Frame.NORMAL);
            registry.get(item).toFront();
            registry.get(item).repaint();
        }
    }

    public void setAllToBack() {
        for (String item : registry.keySet()) {
//           registry.get(item).setState(Frame.ICONIFIED);
            registry.get(item).toBack();
            registry.get(item).repaint();
        }
    }

    public void setAllOnFront(String id) {
        setAllOnFront();
        registry.get(id).toFront();
        registry.get(id).repaint();
    }

    public void registerIconDummy(Frame container) {
        this.iconDummy = container;
    }

    public void closeIconDummy() {
        this.iconDummy.dispose();

    }

    void saveAllOnShutdown() {
        JFrame restoreDummy = new JFrame();
        System.err.println("ddd");
        int result = JOptionPane.showConfirmDialog(restoreDummy, "Save all notes ?", null,
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            NoteRegistry.getInstance().saveAll();
        }
    }
    
    public boolean isEmpty(){
        return registry.isEmpty();
    }

}
