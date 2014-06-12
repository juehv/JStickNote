/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

/**
 *
 * @author Jens
 */
public class ResizeButton extends JButton {
    
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;
    
    public ResizeButton(final JFrame parent) {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //set mosuepressed location to X1 and Y1
                x1 = evt.getX();
                y1 = evt.getY();
            }
            
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                //update the location and size of all child components
            }
        });
        
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                //resize jframe on the fly
                x2 = evt.getX();
                y2 = evt.getY();
                //set minimum size to 100 wide
                if ((parent.getWidth() - (x1 - x2)) < 100) {
                    x2 = x1;
                }
                if ((parent.getHeight() - (y1 - y2)) < 100) {
                    y2 = y1;
                }

                //resize 
                parent.setSize(parent.getWidth() - (x1 - x2), parent.getHeight() - (y1 - y2));
                
            }
        });
    }
    
}
