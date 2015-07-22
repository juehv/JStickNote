/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jens
 */
public final class Note extends javax.swing.JDialog {

    private static final Logger LOG = Logger.getLogger(Note.class.getName());
    private final String id;
    private NoteColor color = ColorSet.getInstance().getColorById(0);
    private Font noteFont;
    private NoteSaveScheduler scheduler = NoteSaveScheduler.getInstance();

    public String getId() {
        return id;
    }

    public String getText() {
        return noteTextEditoPane.getText();
    }

    public NoteContent getContent() {
        NoteContent content = new NoteContent(id);
        content.setText(noteTextEditoPane.getText());
        content.setSize(this.getSize());
        content.setLocation(this.getLocation());
        content.setColor(color);
        return content;
    }

    public void saveNote() {
        try {
            PaperStack.getInstance().addNote(getContent());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while saving note:\n"
                    + ex.getLocalizedMessage());
        }
    }

    public void setNoteColor(NoteColor color) {
        this.color = color;
        noteTextEditoPane.setBackground(color.getNoteColor());
        noteBarPanel.setBackground(color.getBarColor());
    }

    public void initRun() {
        if (PaperStack.getInstance().getAllNotes() != null
                && !PaperStack.getInstance().getAllNotes().isEmpty()) {
            for (NoteContent item : PaperStack.getInstance().getAllNotes()) {
                new Note(item).setVisible(true);
            }
            NoteRegistry.getInstance().unregisterNote(id);
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    public void reloadNotes() {
        // load new stack
        try {
            PaperStack.loadStackFromFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading File.\n"
                    + "Using new empty pad.\n\n" + ex.getLocalizedMessage());
        }

        // reinit app
        NoteRegistry.getInstance().closeAll();
        Note reInit = new Note(IdGenerator.generateRandomId());
        reInit.initRun();
    }

    public Note(NoteContent content) {
        this(content.getId());

        if (content.getText() != null && !content.getText().isEmpty()) {
            noteTextEditoPane.setText(content.getText());
        }

        if (content.getSize() != null) {
            this.setSize(content.getSize());
        }

        if (content.getLocation() != null) {
            this.setLocation(content.getLocation());
        }

        if (content.getColor() != null) {
            this.setNoteColor(content.getColor());
        }
    }

    /**
     * Creates new form Note
     *
     * @param id
     */
    public Note(final String id) {
        this.id = id;

        initComponents();

        // load font
        try {
            InputStream is = Note.class.getResourceAsStream("/de/jensheuschkel/jstickynote/font/eots.ttf");
            noteFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (noteFont != null) {
            noteTextEditoPane.setFont(noteFont.deriveFont(24.0f));
        }

        // add strg+s --> save
        noteTextEditoPane.getInputMap().put(KeyStroke
                .getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK), "save");
        noteTextEditoPane.getActionMap().put("save", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoteRegistry.getInstance().saveAll();
            }
        });

        // add strg+r --> reload
        noteTextEditoPane.getInputMap().put(KeyStroke
                .getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK), "reload");
        noteTextEditoPane.getActionMap().put("reload", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadNotes();
            }
        });

//        // set program icon
//        URL url = ClassLoader.getSystemResource("de/jensheuschkel/jstickynote/icons/appIcon.png");
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Image img = kit.createImage(url);
//        this.setIconImage(img);
        // set all to front if one window is aktivated
        this.addWindowStateListener(new WindowStateListener() {

            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == Frame.NORMAL) {
                    NoteRegistry.getInstance().setAllOnFront(id);
                }
            }
        });

        // register note 
        NoteRegistry.getInstance().registerNote(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noteBarPanel = new MotionPanel(this);
        closeButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        resizeButton = new ResizeButton(this);
        jScrollPane3 = new javax.swing.JScrollPane();
        noteTextEditoPane = new javax.swing.JEditorPane(){
            public boolean getScrollableTracksViewportWidth() {
                return true;
            }
        };
        optionsButton = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton();
        closeAllButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        setMinimumSize(new java.awt.Dimension(230, 100));
        setUndecorated(true);

        noteBarPanel.setBackground(new java.awt.Color(242, 242, 193));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonX.png"))); // NOI18N
        closeButton.setToolTipText("Remove Note");
        closeButton.setBorder(null);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        newButton.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonPlus.png"))); // NOI18N
        newButton.setToolTipText("New Note");
        newButton.setBorder(null);
        newButton.setBorderPainted(false);
        newButton.setContentAreaFilled(false);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        resizeButton.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        resizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonResize.png"))); // NOI18N
        resizeButton.setToolTipText("Resize");
        resizeButton.setBorder(null);
        resizeButton.setBorderPainted(false);
        resizeButton.setContentAreaFilled(false);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBar(null);

        noteTextEditoPane.setBackground(new java.awt.Color(255, 255, 204));
        noteTextEditoPane.setBorder(null);
        noteTextEditoPane.setFont(new java.awt.Font("Comic Sans MS", 2, 22)); // NOI18N
        noteTextEditoPane.setAutoscrolls(false);
        noteTextEditoPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noteTextEditoPaneMouseClicked(evt);
            }
        });
        noteTextEditoPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteTextEditoPaneKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(noteTextEditoPane);

        optionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonOptions.png"))); // NOI18N
        optionsButton.setToolTipText("Options");
        optionsButton.setBorder(null);
        optionsButton.setBorderPainted(false);
        optionsButton.setContentAreaFilled(false);
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });

        reloadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonReload.png"))); // NOI18N
        reloadButton.setToolTipText("Reload File");
        reloadButton.setBorder(null);
        reloadButton.setBorderPainted(false);
        reloadButton.setContentAreaFilled(false);
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        closeAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/jensheuschkel/jstickynote/icons/buttonCloseAll.png"))); // NOI18N
        closeAllButton.setToolTipText("Exit App");
        closeAllButton.setBorder(null);
        closeAllButton.setBorderPainted(false);
        closeAllButton.setContentAreaFilled(false);
        closeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noteBarPanelLayout = new javax.swing.GroupLayout(noteBarPanel);
        noteBarPanel.setLayout(noteBarPanelLayout);
        noteBarPanelLayout.setHorizontalGroup(
            noteBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noteBarPanelLayout.createSequentialGroup()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(closeAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        noteBarPanelLayout.setVerticalGroup(
            noteBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noteBarPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noteBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(noteBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(optionsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(reloadButton)
                        .addGroup(noteBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resizeButton)
                            .addComponent(closeButton)))
                    .addComponent(closeAllButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noteBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noteBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Note note = new Note(IdGenerator.generateRandomId());
                note.setLocationRelativeTo(null);
                note.setVisible(true);
            }
        });
    }//GEN-LAST:event_newButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        int result;
        if (noteTextEditoPane.getText().isEmpty()) {
            result = JOptionPane.YES_OPTION;
        } else {
            result = JOptionPane.showConfirmDialog(this, "Remove Note ?",
                    null, JOptionPane.YES_NO_OPTION);
        }
        if (result == JOptionPane.YES_OPTION) {
            try {
                PaperStack.getInstance().removeNote(this.id);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while removing note file:\n"
                        + ex.getLocalizedMessage());
            }
            NoteRegistry.getInstance().unregisterNote(this.id);
//            NoteRegistry.getInstance().saveAll();
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_closeButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        reloadNotes();
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed
        OptionsDialog options = new OptionsDialog(this);
        options.setVisible(true);        
        
        //TODO note specific options in context menu
        // move this stuff above to the context menu closing
        // options menu should just contain local options, help, donation (and group settings??)
        this.repaint();
        NoteRegistry.getInstance().saveAll();
        // end        
        
        reloadNotes();        
    }//GEN-LAST:event_optionsButtonActionPerformed

    private void closeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeAllButtonActionPerformed
        NoteRegistry.getInstance().saveAllOnShutdown();
        NoteRegistry.getInstance().closeIconDummy();
        NoteRegistry.getInstance().closeAll();
        System.exit(0);
    }//GEN-LAST:event_closeAllButtonActionPerformed

    private void noteTextEditoPaneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteTextEditoPaneKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_TAB) {
            int cursorPostition = noteTextEditoPane.getCaretPosition();
            noteTextEditoPane.setText(noteTextEditoPane.getText().replaceAll("\\t", "    "));
            noteTextEditoPane.setCaretPosition(cursorPostition + 3);
        }
        scheduler.scheduleSave();
    }//GEN-LAST:event_noteTextEditoPaneKeyTyped

    private void noteTextEditoPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteTextEditoPaneMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            NoteRegistry.getInstance().setAllOnFront(id);
        }
    }//GEN-LAST:event_noteTextEditoPaneMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeAllButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newButton;
    private javax.swing.JPanel noteBarPanel;
    private javax.swing.JEditorPane noteTextEditoPane;
    private javax.swing.JButton optionsButton;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton resizeButton;
    // End of variables declaration//GEN-END:variables

}
