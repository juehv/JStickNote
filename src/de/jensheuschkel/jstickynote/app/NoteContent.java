/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import com.thoughtworks.xstream.XStream;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jens
 */
public class NoteContent {

    private final String id;
    private String text;
    private final Map<String, LocalNoteOptions> localOptions;
    private NoteColor color;

    public NoteContent(String id) {
        this.localOptions = new HashMap<>();
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public Dimension getSize() {
        String deviceId = Preferences.getInstance().getDeviceUuid();
        Dimension size = localOptions.get(deviceId).getSize();
        if (size == null) {
            size = LocalNoteOptions.DEFAULT_SIZE;
        }
        return size;
    }

    public void setSize(Dimension size) {
        String deviceId = Preferences.getInstance().getDeviceUuid();
        LocalNoteOptions tmpOpt = localOptions.get(deviceId);
        if (tmpOpt == null){
            tmpOpt = new LocalNoteOptions();
            localOptions.put(deviceId,tmpOpt);
        }
        tmpOpt.setSize(size);
    }

    public Point getLocation() {
        String deviceId = Preferences.getInstance().getDeviceUuid();
        Point location = localOptions.get(deviceId).getLocation();
        if (location == null) {
            location = LocalNoteOptions.DEFAULT_LOCATION;
        }
        return location;
    }

    public void setLocation(Point location) {
        String deviceId = Preferences.getInstance().getDeviceUuid();
        LocalNoteOptions tmpOpt = localOptions.get(deviceId);
        if (tmpOpt == null){
            tmpOpt = new LocalNoteOptions();
            localOptions.put(deviceId,tmpOpt);
        }
        tmpOpt.setLocation(location);
    }

    public NoteColor getColor() {
        return color;
    }

    public void setColor(NoteColor color) {
        this.color = color;
    }

    public String toXml(){
        XStream xml = new XStream();
        return xml.toXML(this);
    }
    
    public static NoteContent fromXml(String xmlString){
        if (xmlString == null || xmlString.isEmpty()) {
            return null;
        } else {
            XStream xml = new XStream();
            return (NoteContent) xml.fromXML(xmlString);
        }
    }
}
