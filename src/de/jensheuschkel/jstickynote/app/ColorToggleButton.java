/*
 * Copyright (C) 2014 Jens
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Graphics;
import javax.swing.JToggleButton;

/**
 *
 * @author Jens
 */
public class ColorToggleButton extends JToggleButton {

    private final NoteColor color;

    public ColorToggleButton(NoteColor color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isSelected()) {
            g.setColor(color.getBarColor());
        } else {
            g.setColor(color.getNoteColor());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
