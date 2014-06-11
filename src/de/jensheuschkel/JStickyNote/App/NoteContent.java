/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.JStickyNote.App;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Jens
 */
public class NoteContent {

    private final String id;
    private String text;
    private Dimension size;
    private Point location;
    private NoteColor color;

    public NoteContent(String id) {
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
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public NoteColor getColor() {
        return color;
    }

    public void setColor(NoteColor color) {
        this.color = color;
    }
    
    
}
