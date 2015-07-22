/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.nio.file.Paths;
import java.util.UUID;

/**
 *
 * @author Jens
 */
public class Preferences {

    public static final String ID_SAVE_PATH = "savepath_";
    public static final String ID_SAVE_IDS = "savepath_ids";
    public static final String ID_ACTIVE_SAVE_PATH_ID = "active_savepath";
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

    public void setSavePath(String id, String path) {
        // mach die haare schön
        path = path.replaceAll("\\\\", "/");
        if (!(path.endsWith("/") || path.endsWith("\\"))) {
            path += "/";
        }
        //save
        prefs.put(ID_SAVE_PATH + id, path);

        // Check if id is there
        boolean found = false;
        String[] ids = this.getAllSavePathIds();
        for (String item : ids) {
            if (item.equalsIgnoreCase(id)) {
                found = true;
                break;
            }
        }
        // add new id if not
        if (!found) {
            String rawIds = prefs.get(ID_SAVE_IDS, "");
            if (rawIds.isEmpty()) {
                rawIds += ";";
            }
            rawIds += id;
            prefs.put(ID_SAVE_IDS, rawIds);
        }
    }

    public String getActiveSavePath() {
        String id = prefs.get(ID_ACTIVE_SAVE_PATH_ID, "");
        // if ID is empty prefs will return the def anyway
        return prefs.get(ID_SAVE_PATH + id, DEF_SAVE_PATH);
    }

    public void setActiveSavePath(String id) {
        prefs.put(ID_ACTIVE_SAVE_PATH_ID, id);
    }

    public String[] getAllSavePathIds() {
        String rawIds = prefs.get(ID_SAVE_IDS, "");
        String[] ids = rawIds.split(";");
        //TODO preprocessing ?!
        return ids;
    }

    public void putSavePathIds(String[] ids) {
        StringBuilder sb = new StringBuilder();
        for (String id : ids) {
            sb.append(id).append(";");
        }
        // remove the last ;
        sb.deleteCharAt(sb.length() - 1);
        prefs.put(ID_SAVE_IDS, sb.toString());
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
