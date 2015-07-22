/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.util.UUID;

/**
 *
 * @author Jens
 */
public class Preferences {

    public static final String ID_SAVE_PATH = "savepath";
    public static final String ID_DEIVCE_UUID = "device_id";
    public static final String DEF_SAVE_PATH = "./jstickynote.xml";
    private static Preferences INSTANCE;
    private java.util.prefs.Preferences prefs = java.util.prefs.Preferences
            .userRoot().node(this.getClass().getName());

    private Preferences() {
        // empty
    }

    public static Preferences getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Preferences();
        }
        return INSTANCE;
    }

    public void setSavePath(String path) {
        prefs.put(ID_SAVE_PATH, path);
    }

    public String getSavePath() {
        return prefs.get(ID_SAVE_PATH, DEF_SAVE_PATH);
    }

    public String getDeviceUuid() {
        String id = prefs.get(ID_DEIVCE_UUID, "");
        if (id.isEmpty()) {
            id = UUID.randomUUID().toString();
            prefs.put(ID_DEIVCE_UUID, id);
        }
        return id;
    }
}
