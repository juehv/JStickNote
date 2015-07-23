/*
 * Copyright (C) 2015 Jens
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

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Jens
 */
public class LocalNoteOptions {

    public static final Dimension DEFAULT_SIZE = new Dimension(300, 300);
    public static final Point DEFAULT_LOCATION = new Point(10, 10);
    private Dimension size;
    private Point location;

    public LocalNoteOptions() {
        size = DEFAULT_SIZE;
        location = DEFAULT_LOCATION;
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

    public void setLocation(Point locations) {
        this.location = locations;
    }

}
