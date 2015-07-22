/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Jens
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Load Notes
            PaperStack.loadStackFromFile();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading File.\n"
                    + "Using new empty pad.\n\n" + ex.getLocalizedMessage());
        }

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // empty
        }

        // Start App
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                IconDummy cont = new IconDummy();
                cont.setVisible(true);
                Note note = new Note(IdGenerator.generateRandomId());
                note.initRun();
//                note.setVisible(true);
            }
        });

    }

}
