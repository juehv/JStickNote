/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

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
    private Dimension size;
    private final Map<String, Point> locations;
    private NoteColor color;

    public NoteContent(String id) {
        this.locations = new HashMap<>();
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
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getLocation() {
        Point location = locations.get(Preferences.getInstance().getDeviceUuid());
        if (location == null) {
            location = new Point(10, 10);
        }
        return location;
    }

    public void setLocation(Point location) {
        locations.put(Preferences.getInstance().getDeviceUuid(), location);
    }

    public NoteColor getColor() {
        return color;
    }

    public void setColor(NoteColor color) {
        this.color = color;
    }

}
