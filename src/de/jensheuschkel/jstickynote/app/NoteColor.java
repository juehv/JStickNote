/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Color;

/**
 *
 * @author Jens
 */
public class NoteColor {

    private final Color barColor;
    private final Color noteColor;
    private final String name;
    private final int id;

    public NoteColor(Color barColor, Color noteColor, String name, int id) {
        this.barColor = barColor;
        this.noteColor = noteColor;
        this.name = name;
        this.id = id;
    }

    public Color getBarColor() {
        return barColor;
    }

    public Color getNoteColor() {
        return noteColor;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
