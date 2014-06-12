/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jens
 */
public class ColorSet {

    private static ColorSet INSTANCE;
    private final List<NoteColor> colorSet = new ArrayList<>();

    private void init() {
        colorSet.add(new NoteColor(new Color(242, 242, 193),
                new Color(255, 255, 204), "yellow", 0));
        colorSet.add(new NoteColor(new Color(143, 194, 245),
                new Color(153, 204, 255), "blue", 1));
        colorSet.add(new NoteColor(new Color(242, 193, 193),
                new Color(255, 204, 204), "red", 2));
        colorSet.add(new NoteColor(new Color(193, 242, 193),
                new Color(204, 255, 204), "green", 3));
        colorSet.add(new NoteColor(new Color(213, 193, 242),
                new Color(224, 204, 255), "purple", 4));
        colorSet.add(new NoteColor(new Color(245, 163, 215),
                new Color(255, 173, 225), "pink", 5));
    }

    private ColorSet() {
        init();
    }

    public static ColorSet getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ColorSet();
        }
        return INSTANCE;
    }

    public NoteColor getColorById(int id) {
        for (NoteColor item : colorSet) {
            if (item.getId() == id) {
                return item;
            }
        }
        return colorSet.get(0);
    }

    public NoteColor getColorByName(String name) {
        for (NoteColor item : colorSet) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return colorSet.get(0);
    }

    public String[] getNames() {
        String[] names = new String[colorSet.size()];
        for (int i = 0; i < colorSet.size(); i++) {
            names[i] = colorSet.get(i).getName();
        }
        return names;
    }

}
