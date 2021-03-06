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

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Jens
 */
public class NoteSaveScheduler {

    private static final long SCHEDULE_TIME = 15000;
    private static NoteSaveScheduler INSTANCE;
    private boolean schedule = false;
    private final Timer timer = new Timer();

    private NoteSaveScheduler() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (schedule) {
                    NoteRegistry.getInstance().saveAll();
                }
                schedule = false;
            }
        }, SCHEDULE_TIME, SCHEDULE_TIME);
    }

    public static NoteSaveScheduler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NoteSaveScheduler();
        }
        return INSTANCE;
    }

    public void scheduleSave() {
        schedule = true;
    }
}
