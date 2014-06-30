/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jens
 */
public class OptionsDialog extends javax.swing.JDialog {

    private final Note note;
    private NoteColor selectedColor;

    private void resetColorButtons() {
        pinkButton.setSelected(false);
        purpleButton.setSelected(false);
        redButton.setSelected(false);
        yellowButton.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton9.setSelected(false);
        blueButton.setSelected(false);
        greenButton.setSelected(false);
    }

    private void initColorButtons() {
        ColorSet cs = ColorSet.getInstance();
        if (selectedColor == cs.getColorByName("yellow")) {
            yellowButton.setSelected(true);
        } else if (selectedColor == cs.getColorByName("blue")) {
            blueButton.setSelected(true);
        } else if (selectedColor == cs.getColorByName("red")) {
            redButton.setSelected(true);
        } else if (selectedColor == cs.getColorByName("green")) {
            greenButton.setSelected(true);
        } else if (selectedColor == cs.getColorByName("purple")) {
            purpleButton.setSelected(true);
        } else if (selectedColor == cs.getColorByName("pink")) {
            pinkButton.setSelected(true);
        }
    }

    /**
     * Creates new form OptionsDialog
     *
     * @param note
     */
    public OptionsDialog(Note note) {
        super(note, true);
        this.note = note;
        this.selectedColor = note.getContent().getColor();
        initComponents();
        setLocationRelativeTo(note);
        initColorButtons();
//        for (String color : ColorSet.getInstance().getNames()) {
////            colorComboBox.addItem(color);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        colorLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idTextLabel = new javax.swing.JLabel();
        ColorPanel = new javax.swing.JPanel();
        yellowButton = new de.jensheuschkel.jstickynote.app.ColorToggleButton(ColorSet.getInstance().getColorByName("yellow"));
        blueButton = new ColorToggleButton(ColorSet.getInstance().getColorByName("blue"));
        redButton = new ColorToggleButton(ColorSet.getInstance().getColorByName("red"));
        greenButton = new ColorToggleButton(ColorSet.getInstance().getColorByName("green"));
        purpleButton = new ColorToggleButton(ColorSet.getInstance().getColorByName("purple"));
        pinkButton = new ColorToggleButton(ColorSet.getInstance().getColorByName("pink"));
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        noteFileLabel = new javax.swing.JLabel();
        noteFileTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        activeFileRadioButton = new javax.swing.JRadioButton();
        activeFileRadioButton1 = new javax.swing.JRadioButton();
        noteFileLabel1 = new javax.swing.JLabel();
        noteFileTextField1 = new javax.swing.JTextField();
        browseButton1 = new javax.swing.JButton();
        activeFileRadioButton2 = new javax.swing.JRadioButton();
        noteFileLabel2 = new javax.swing.JLabel();
        noteFileTextField2 = new javax.swing.JTextField();
        browseButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        websiteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        donateButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        colorLabel.setText("Color:");

        idLabel.setText("ID:");

        idTextLabel.setText(note.getId());

        yellowButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        yellowButton.setForeground(new java.awt.Color(255, 255, 204));
        yellowButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        yellowButton.setPreferredSize(new java.awt.Dimension(30, 30));
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        blueButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blueButton.setForeground(new java.awt.Color(153, 204, 255));
        blueButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        blueButton.setPreferredSize(new java.awt.Dimension(30, 30));
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        redButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        redButton.setForeground(new java.awt.Color(255, 204, 204));
        redButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        redButton.setPreferredSize(new java.awt.Dimension(30, 30));
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        greenButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        greenButton.setForeground(new java.awt.Color(204, 255, 204));
        greenButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        greenButton.setPreferredSize(new java.awt.Dimension(30, 30));
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        purpleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        purpleButton.setForeground(new java.awt.Color(224, 204, 255));
        purpleButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        purpleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        purpleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleButtonActionPerformed(evt);
            }
        });

        pinkButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pinkButton.setForeground(new java.awt.Color(255, 173, 225));
        pinkButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pinkButton.setPreferredSize(new java.awt.Dimension(30, 30));
        pinkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinkButtonActionPerformed(evt);
            }
        });

        jToggleButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton7.setText("X");
        jToggleButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton7.setEnabled(false);
        jToggleButton7.setPreferredSize(new java.awt.Dimension(30, 30));

        jToggleButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton8.setText("X");
        jToggleButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton8.setEnabled(false);
        jToggleButton8.setPreferredSize(new java.awt.Dimension(30, 30));

        jToggleButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToggleButton9.setText("X");
        jToggleButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton9.setEnabled(false);
        jToggleButton9.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout ColorPanelLayout = new javax.swing.GroupLayout(ColorPanel);
        ColorPanel.setLayout(ColorPanelLayout);
        ColorPanelLayout.setHorizontalGroup(
            ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColorPanelLayout.createSequentialGroup()
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ColorPanelLayout.createSequentialGroup()
                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ColorPanelLayout.createSequentialGroup()
                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ColorPanelLayout.setVerticalGroup(
            ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColorPanelLayout.createSequentialGroup()
                .addGroup(ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorLabel)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTextLabel)
                    .addComponent(ColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorLabel)
                    .addComponent(ColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Note", jPanel1);

        jScrollPane2.setViewportView(jList1);

        jButton1.setText("New");

        jButton2.setText("Remove");

        jButton3.setText("Set Active");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Groups", jPanel5);

        noteFileLabel.setText("Note File 1:");

        noteFileTextField.setText(Preferences.getInstance().getSavePath());

        browseButton.setText("...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        activeFileRadioButton.setSelected(true);
        activeFileRadioButton.setText("active");

        activeFileRadioButton1.setText("active");
        activeFileRadioButton1.setEnabled(false);

        noteFileLabel1.setText("Note File 2:");
        noteFileLabel1.setEnabled(false);

        noteFileTextField1.setText(Preferences.getInstance().getSavePath());
        noteFileTextField1.setEnabled(false);

        browseButton1.setText("...");
        browseButton1.setEnabled(false);
        browseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButton1ActionPerformed(evt);
            }
        });

        activeFileRadioButton2.setText("active");
        activeFileRadioButton2.setEnabled(false);

        noteFileLabel2.setText("Note File 3:");
        noteFileLabel2.setEnabled(false);

        noteFileTextField2.setText(Preferences.getInstance().getSavePath());
        noteFileTextField2.setEnabled(false);

        browseButton2.setText("...");
        browseButton2.setEnabled(false);
        browseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activeFileRadioButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activeFileRadioButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activeFileRadioButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(noteFileTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileLabel)
                    .addComponent(activeFileRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileLabel1)
                    .addComponent(activeFileRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileLabel2)
                    .addComponent(activeFileRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteFileTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Files", jPanel2);

        jLabel1.setText("Shortcuts:");

        websiteButton.setText("Go to Website");
        websiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("CTRL+S -- save");

        jLabel3.setText("CTRL+R -- reload file");

        jLabel4.setText("CTRL+G -- next group");

        jLabel5.setText("Tipps:");

        jLabel6.setText("Use WIN+D to minimize the APP");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(websiteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(websiteButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Help", jPanel4);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("JStickyNote\n(c) Jens Heuschkel\nv1.0 Beta\n\nLicense: GPL v3\njstickynote@juehv-tech.de");
        jScrollPane1.setViewportView(jTextArea1);

        donateButton.setText("Donate");
        donateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(donateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(donateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("About", jPanel3);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // color
//        NoteColor color = ColorSet.getInstance()
//                .getColorByName(colorComboBox.getSelectedItem().toString());
//        note.setNoteColor(color);
        // savepath
        if (!noteFileTextField.getText().isEmpty()) {
            Preferences.getInstance().setSavePath(noteFileTextField.getText());
        }

        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser fc = new JFileChooser(noteFileTextField.getText());
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String newPath = fc.getSelectedFile().getAbsolutePath();
            noteFileTextField.setText(newPath);
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void donateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URI(
                    "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=5465UQ6WHWV7E"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE,
                    null, ex);
            JOptionPane.showMessageDialog(this,
                    "An unexpected error ocured: " + ex.getLocalizedMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_donateButtonActionPerformed

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButtonActionPerformed
        resetColorButtons();
        yellowButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("yellow");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_yellowButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        resetColorButtons();
        blueButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("blue");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_blueButtonActionPerformed

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        resetColorButtons();
        redButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("red");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_redButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        resetColorButtons();
        greenButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("green");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_greenButtonActionPerformed

    private void purpleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleButtonActionPerformed
        resetColorButtons();
        purpleButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("purple");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_purpleButtonActionPerformed

    private void pinkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinkButtonActionPerformed
        resetColorButtons();
        pinkButton.setSelected(true);
        selectedColor = ColorSet.getInstance().getColorByName("pink");
        note.setNoteColor(selectedColor);
        this.dispose();
    }//GEN-LAST:event_pinkButtonActionPerformed

    private void browseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browseButton1ActionPerformed

    private void browseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browseButton2ActionPerformed

    private void websiteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteButtonActionPerformed
         try {
            Desktop.getDesktop().browse(new URI(
                    "http://www.juehv-tech.de/qad/jstickynote"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(OptionsDialog.class.getName()).log(Level.SEVERE,
                    null, ex);
            JOptionPane.showMessageDialog(this,
                    "An unexpected error ocured: " + ex.getLocalizedMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_websiteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ColorPanel;
    private javax.swing.JRadioButton activeFileRadioButton;
    private javax.swing.JRadioButton activeFileRadioButton1;
    private javax.swing.JRadioButton activeFileRadioButton2;
    private javax.swing.JToggleButton blueButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browseButton1;
    private javax.swing.JButton browseButton2;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton donateButton;
    private javax.swing.JToggleButton greenButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idTextLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JLabel noteFileLabel;
    private javax.swing.JLabel noteFileLabel1;
    private javax.swing.JLabel noteFileLabel2;
    private javax.swing.JTextField noteFileTextField;
    private javax.swing.JTextField noteFileTextField1;
    private javax.swing.JTextField noteFileTextField2;
    private javax.swing.JButton okButton;
    private javax.swing.JToggleButton pinkButton;
    private javax.swing.JToggleButton purpleButton;
    private javax.swing.JToggleButton redButton;
    private javax.swing.JButton websiteButton;
    private javax.swing.JToggleButton yellowButton;
    // End of variables declaration//GEN-END:variables
}
