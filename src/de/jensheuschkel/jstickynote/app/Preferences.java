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

    public static final String ID_SAVE_PATH1 = "savepath1";
    public static final String ID_SAVE_PATH1_ACTIVE = "savepath1_active";
    public static final String ID_SAVE_PATH2 = "savepath2";
    public static final String ID_SAVE_PATH2_ACTIVE = "savepath2_active";
    public static final String ID_SAVE_PATH3 = "savepath3";
    public static final String ID_SAVE_PATH3_ACTIVE = "savepath3_active";
    public static final String ID_DEIVCE_UUID = "device_id";
    public static final String DEF_SAVE_PATH = "./notes/";
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

    public void setSavePath1(String path) {
        prefs.put(ID_SAVE_PATH1, path);
    }

    public String getSavePath1() {
        return prefs.get(ID_SAVE_PATH1, DEF_SAVE_PATH);
    }

    public void setSavePath1Active(boolean isActive) {
        prefs.putBoolean(ID_SAVE_PATH1_ACTIVE, isActive);
    }

    public boolean isSavePath1Active() {
        return prefs.getBoolean(ID_SAVE_PATH1_ACTIVE, true);
    }

    public void setSavePath2(String path) {
        prefs.put(ID_SAVE_PATH2, path);
    }

    public String getSavePath2() {
        return prefs.get(ID_SAVE_PATH2, DEF_SAVE_PATH);
    }

    public void setSavePath2Active(boolean isActive) {
        prefs.putBoolean(ID_SAVE_PATH2_ACTIVE, isActive);
    }

    public boolean isSavePath2Active() {
        return prefs.getBoolean(ID_SAVE_PATH2_ACTIVE, false);
    }

    public void setSavePath3(String path) {
        prefs.put(ID_SAVE_PATH3, path);
    }

    public String getSavePath3() {
        return prefs.get(ID_SAVE_PATH3, DEF_SAVE_PATH);
    }

    public void setSavePath3Active(boolean isActive) {
        prefs.putBoolean(ID_SAVE_PATH3_ACTIVE, isActive);
    }

    public boolean isSavePath3Active() {
        return prefs.getBoolean(ID_SAVE_PATH3_ACTIVE, false);
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
