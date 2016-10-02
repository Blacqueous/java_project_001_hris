package img_emp_src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import project_001_hris.SaveImageFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author egrubellano
 */
public class ClassImageCropPanelv2 extends javax.swing.JPanel {

    /**
     * Creates new form ClassImageCropPanelv2
     */
    public ClassImageCropPanelv2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelControls = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();
        btnBrowse = new javax.swing.JButton();
        panelImageDock = new img_emp_src.ClassImageAreaPanel();

        setLayout(new java.awt.GridBagLayout());

        panelControls.setOpaque(false);
        panelControls.setPreferredSize(new java.awt.Dimension(513, 25));
        panelControls.setLayout(new java.awt.BorderLayout());

        slider.setValue(0);
        slider.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        slider.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        slider.setOpaque(false);
        panelControls.add(slider, java.awt.BorderLayout.CENTER);

        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_img_landscape_add.png"))); // NOI18N
        btnBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowse.setMaximumSize(new java.awt.Dimension(25, 25));
        btnBrowse.setMinimumSize(new java.awt.Dimension(25, 25));
        btnBrowse.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        panelControls.add(btnBrowse, java.awt.BorderLayout.LINE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panelControls, gridBagConstraints);

        javax.swing.GroupLayout panelImageDockLayout = new javax.swing.GroupLayout(panelImageDock);
        panelImageDock.setLayout(panelImageDockLayout);
        panelImageDockLayout.setHorizontalGroup(
            panelImageDockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        panelImageDockLayout.setVerticalGroup(
            panelImageDockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panelImageDock, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, and PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            javaxt.io.Image imageIO = new javaxt.io.Image(file.getAbsolutePath());
            // System.out.println("You chose to open this file: " + file.getName());
            
            int size_base;
            int size_image;
            int size_ratio;
            
            // Choose what size to follow based on this panel
            if(panelImageDock.getHeight() > panelImageDock.getWidth()) { // What the height!!!
                size_base = panelImageDock.getHeight();
            } else if(panelImageDock.getWidth() > panelImageDock.getHeight()) { // Oh shit! The width!!!
                size_base = panelImageDock.getWidth();
            } else { // Maybe they're equal
                size_base = panelImageDock.getHeight();
            }
            
            // Check image size
            if(imageIO.getHeight() > imageIO.getWidth()) { // What the height!!!
                // Check which has a greater value
                if(imageIO.getWidth()> size_base) {
                    size_ratio = (int)(imageIO.getWidth()- size_base);
                } else if(size_base > imageIO.getWidth()) {
                    size_ratio = (int)(size_base - imageIO.getWidth());
                } else {
                    size_ratio = (int)(imageIO.getWidth());
                }
                size_image = imageIO.getHeight();
                // System.out.println("height");
            } else if(imageIO.getWidth() > imageIO.getHeight()) { // Oh shit! The width!!!
                // Check which has a greater value
                if(imageIO.getHeight() > size_base) {
                    size_ratio = (int)(imageIO.getHeight() - size_base);
                } else if(size_base > imageIO.getHeight()) {
                    size_ratio = (int)(size_base - imageIO.getHeight());
                } else {
                    size_ratio = (int)(imageIO.getHeight());
                }
                size_image = imageIO.getWidth();
                // System.out.println("width");
            } else { // Maybe they're equal
                size_ratio = (int)(imageIO.getHeight());
                size_image = imageIO.getHeight();
                // System.out.println("equal");
            }
            
//            // Check image size
//            if(imageIO.getHeight() > imageIO.getWidth()) { // What the height!!!
//                // Check which has a greater value
//                if(imageIO.getHeight()> size_base) {
//                    size_ratio = (int)(imageIO.getHeight()- size_base);
//                } else if(size_base > imageIO.getHeight()) {
//                    size_ratio = (int)(size_base - imageIO.getHeight());
//                } else {
//                    size_ratio = (int)(imageIO.getHeight());
//                }
//                size_image = imageIO.getHeight();
//                // System.out.println("height");
//            } else if(imageIO.getWidth() > imageIO.getHeight()) { // Oh shit! The width!!!
//                // Check which has a greater value
//                if(imageIO.getWidth() > size_base) {
//                    size_ratio = (int)(imageIO.getWidth() - size_base);
//                } else if(size_base > imageIO.getWidth()) {
//                    size_ratio = (int)(size_base - imageIO.getWidth());
//                } else {
//                    size_ratio = (int)(imageIO.getWidth());
//                }
//                size_image = imageIO.getWidth();
//                // System.out.println("width");
//            } else { // Maybe they're equal
//                size_ratio = (int)(imageIO.getHeight());
//                size_image = imageIO.getHeight();
//                // System.out.println("equal");
//            }
            
            
            System.out.println("size base : " + size_base);
            System.out.println("size image : " + size_image);
            System.out.println("size ratio : " + size_ratio);
            System.out.println("image : " + (imageIO.getWidth()-size_ratio) + "x" + (imageIO.getHeight()-size_ratio));
            System.out.println("image : " + imageIO.getWidth() + "x" + imageIO.getHeight());
            System.out.println("panel : " + panelImageDock.getWidth() + "x" + panelImageDock.getHeight());
            System.out.println("\n\n");
            
            
//            int new_height = imageIO.getHeight() - size_ratio;
//            int new_width = imageIO.getWidth() - size_ratio;
            

//            imageIO.resize((imageIO.getWidth()-size_ratio), (imageIO.getHeight()-size_ratio), true);
            int size;
            if(panelImageDock.getHeight() >= panelImageDock.getWidth()) {
                size = panelImageDock.getWidth() - size_ratio;
                imageIO.resize(panelImageDock.getHeight(), panelImageDock.getHeight(), true);
            } else {
                size = panelImageDock.getHeight() - size_ratio;
                imageIO.resize(panelImageDock.getWidth(), panelImageDock.getWidth(), true);
            }
            
            
            System.out.println("image : " + imageIO.getWidth() + "x" + imageIO.getHeight());
            
            panelImageDock.setImage(imageIO.getBufferedImage());
            // System.out.println("Done.");

            this.repaint();
        }
        
    }//GEN-LAST:event_btnBrowseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JPanel panelControls;
    private img_emp_src.ClassImageAreaPanel panelImageDock;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
