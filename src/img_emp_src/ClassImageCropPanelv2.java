package img_emp_src;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    private final JFileChooser chooser = new JFileChooser(System.getProperty("user.home") +"/Pictures");
    private String filepath = "";
    private int zoom = 0;

    /**
     * Creates new form ClassImageCropPanelv2
     */
    public ClassImageCropPanelv2() {
        initComponents();
        addlComponents();
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
        panelControlType0 = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();
        btnBrowseType0 = new javax.swing.JButton();
        panelControlType1 = new javax.swing.JPanel();
        panelZoom = new javax.swing.JPanel();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        btnBrowseType1 = new javax.swing.JButton();
        panelControlType2 = new javax.swing.JPanel();
        btnBrowseType2 = new javax.swing.JButton();
        panelMode = new javax.swing.JPanel();
        panelModeSome = new javax.swing.JPanel();
        panelModeFull = new javax.swing.JPanel();
        panelZoomRefresh = new javax.swing.JPanel();
        btnZoomRefresh = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        classImageAreaPanelv2 = new img_emp_src.ClassImageAreaPanelv2().create();

        setMaximumSize(new java.awt.Dimension(150, 150));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(150, 150));
        setLayout(new java.awt.GridBagLayout());

        panelControls.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panelControls.setMaximumSize(new java.awt.Dimension(30, 30));
        panelControls.setMinimumSize(new java.awt.Dimension(30, 30));
        panelControls.setOpaque(false);
        panelControls.setPreferredSize(new java.awt.Dimension(30, 30));
        panelControls.setLayout(new java.awt.CardLayout());

        panelControlType0.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelControlType0.setMaximumSize(new java.awt.Dimension(30, 30));
        panelControlType0.setMinimumSize(new java.awt.Dimension(30, 30));
        panelControlType0.setOpaque(false);
        panelControlType0.setPreferredSize(new java.awt.Dimension(30, 30));
        panelControlType0.setLayout(new java.awt.BorderLayout());

        slider.setMaximum(500);
        slider.setValue(0);
        slider.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        slider.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        slider.setOpaque(false);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        panelControlType0.add(slider, java.awt.BorderLayout.CENTER);

        btnBrowseType0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_img_landscape_add.png"))); // NOI18N
        btnBrowseType0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowseType0.setMaximumSize(new java.awt.Dimension(25, 25));
        btnBrowseType0.setMinimumSize(new java.awt.Dimension(25, 25));
        btnBrowseType0.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBrowseType0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseType0ActionPerformed(evt);
            }
        });
        panelControlType0.add(btnBrowseType0, java.awt.BorderLayout.LINE_START);

        panelControls.add(panelControlType0, "card_type_0");

        panelControlType1.setOpaque(false);
        panelControlType1.setLayout(new java.awt.BorderLayout());

        panelZoom.setMaximumSize(new java.awt.Dimension(50, 25));
        panelZoom.setMinimumSize(new java.awt.Dimension(50, 25));
        panelZoom.setOpaque(false);
        panelZoom.setPreferredSize(new java.awt.Dimension(50, 25));
        panelZoom.setLayout(new java.awt.GridLayout(1, 0));

        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_magnifier_zoom_out.png"))); // NOI18N
        btnZoomIn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnZoomIn.setMaximumSize(new java.awt.Dimension(25, 25));
        btnZoomIn.setMinimumSize(new java.awt.Dimension(25, 25));
        btnZoomIn.setNextFocusableComponent(btnZoomOut);
        btnZoomIn.setPreferredSize(new java.awt.Dimension(25, 25));
        btnZoomIn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_zoom_out.png"))); // NOI18N
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });
        panelZoom.add(btnZoomIn);

        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_magnifier_zoom_in.png"))); // NOI18N
        btnZoomOut.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnZoomOut.setMaximumSize(new java.awt.Dimension(25, 25));
        btnZoomOut.setMinimumSize(new java.awt.Dimension(25, 25));
        btnZoomOut.setNextFocusableComponent(btnZoomRefresh);
        btnZoomOut.setPreferredSize(new java.awt.Dimension(25, 25));
        btnZoomOut.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_zoom_in.png"))); // NOI18N
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });
        panelZoom.add(btnZoomOut);

        panelControlType1.add(panelZoom, java.awt.BorderLayout.LINE_END);

        btnBrowseType1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_photo.png"))); // NOI18N
        btnBrowseType1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowseType1.setFocusTraversalPolicyProvider(true);
        btnBrowseType1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnBrowseType1.setMaximumSize(new java.awt.Dimension(25, 25));
        btnBrowseType1.setMinimumSize(new java.awt.Dimension(25, 25));
        btnBrowseType1.setNextFocusableComponent(btnZoomIn);
        btnBrowseType1.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBrowseType1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnBrowseType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseType1ActionPerformed(evt);
            }
        });
        panelControlType1.add(btnBrowseType1, java.awt.BorderLayout.LINE_START);

        panelControls.add(panelControlType1, "card_type_1");

        panelControlType2.setOpaque(false);
        panelControlType2.setLayout(new java.awt.BorderLayout());

        btnBrowseType2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_photo.png"))); // NOI18N
        btnBrowseType2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowseType2.setFocusTraversalPolicyProvider(true);
        btnBrowseType2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnBrowseType2.setMaximumSize(new java.awt.Dimension(25, 25));
        btnBrowseType2.setMinimumSize(new java.awt.Dimension(25, 25));
        btnBrowseType2.setNextFocusableComponent(btnZoomIn);
        btnBrowseType2.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBrowseType2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnBrowseType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseType2ActionPerformed(evt);
            }
        });
        panelControlType2.add(btnBrowseType2, java.awt.BorderLayout.LINE_START);

        panelControls.add(panelControlType2, "card_type_2");

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

        panelMode.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
        panelMode.setMaximumSize(new java.awt.Dimension(30, 30));
        panelMode.setMinimumSize(new java.awt.Dimension(30, 30));
        panelMode.setOpaque(false);
        panelMode.setPreferredSize(new java.awt.Dimension(30, 30));
        panelMode.setLayout(new java.awt.CardLayout());

        panelModeSome.setOpaque(false);

        javax.swing.GroupLayout panelModeSomeLayout = new javax.swing.GroupLayout(panelModeSome);
        panelModeSome.setLayout(panelModeSomeLayout);
        panelModeSomeLayout.setHorizontalGroup(
            panelModeSomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        panelModeSomeLayout.setVerticalGroup(
            panelModeSomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        panelMode.add(panelModeSome, "card_mode_0");

        panelModeFull.setOpaque(false);
        panelModeFull.setLayout(new java.awt.BorderLayout());

        panelZoomRefresh.setMaximumSize(new java.awt.Dimension(25, 25));
        panelZoomRefresh.setOpaque(false);
        panelZoomRefresh.setLayout(new java.awt.GridLayout(1, 0));

        btnZoomRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_arrow_refresh.png"))); // NOI18N
        btnZoomRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnZoomRefresh.setMargin(new java.awt.Insets(0, 0, 0, 1));
        btnZoomRefresh.setMaximumSize(new java.awt.Dimension(25, 25));
        btnZoomRefresh.setMinimumSize(new java.awt.Dimension(25, 25));
        btnZoomRefresh.setNextFocusableComponent(btnBrowseType1);
        btnZoomRefresh.setPreferredSize(new java.awt.Dimension(25, 25));
        btnZoomRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomRefreshActionPerformed(evt);
            }
        });
        panelZoomRefresh.add(btnZoomRefresh);

        panelModeFull.add(panelZoomRefresh, java.awt.BorderLayout.LINE_START);

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_thumb_up.png"))); // NOI18N
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSubmit.setMaximumSize(new java.awt.Dimension(25, 25));
        btnSubmit.setMinimumSize(new java.awt.Dimension(25, 25));
        btnSubmit.setNextFocusableComponent(btnBrowseType1);
        btnSubmit.setPreferredSize(new java.awt.Dimension(25, 25));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        panelModeFull.add(btnSubmit, java.awt.BorderLayout.CENTER);

        panelMode.add(panelModeFull, "card_mode_1");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panelMode, gridBagConstraints);

        classImageAreaPanelv2.setBackground(new java.awt.Color(255, 255, 255));
        classImageAreaPanelv2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                classImageAreaPanelv2MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                classImageAreaPanelv2MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout classImageAreaPanelv2Layout = new javax.swing.GroupLayout(classImageAreaPanelv2);
        classImageAreaPanelv2.setLayout(classImageAreaPanelv2Layout);
        classImageAreaPanelv2Layout.setHorizontalGroup(
            classImageAreaPanelv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        classImageAreaPanelv2Layout.setVerticalGroup(
            classImageAreaPanelv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(classImageAreaPanelv2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void addlComponents() {
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, and PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        
        // Set cropped image extension.
        setCropExtension("png");
        
        classImageAreaPanelv2.revalidate();// Revalidate image area.
        classImageAreaPanelv2.repaint(); // Repaint image area.
        
        // Reset zoom slider
        slider.setValue(0); // Reset values
        slider.setEnabled(false); // Reset enability
        zoom = 0; // Rest zoom integer value.
        
        // Set panels to be used.
        setPanelControls(0);
        setPanelMode(0);
        
        // Repaint this panel.
        this.repaint();
        
    }

    private void btnBrowseType0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseType0ActionPerformed
        
        // Get filechooser result.
        int returnVal = chooser.showOpenDialog(this);
        
        // Check if selected file is an image.
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            // Check if selected file is an image.
            File file = chooser.getSelectedFile();
            
            // Get selected image's full path.
            filepath = file.getAbsolutePath();
            
            // Process selected image to panel.
            setImagePanel(file.getAbsolutePath(), 0);
            
            // Reset zoom integer value.
            zoom = 0;
        }
        
    }//GEN-LAST:event_btnBrowseType0ActionPerformed

    private void classImageAreaPanelv2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classImageAreaPanelv2MouseMoved
        
        // Repaint this panel.
        this.repaint();
        
    }//GEN-LAST:event_classImageAreaPanelv2MouseMoved

    private void classImageAreaPanelv2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classImageAreaPanelv2MouseDragged
        
        // Repaint this panel.
        this.repaint();
        
    }//GEN-LAST:event_classImageAreaPanelv2MouseDragged

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        
        // Resize image using slider's value.
        classImageAreaPanelv2.resizeImage(slider.getValue());
        
        // Repaint this panel.
        this.repaint();
        
    }//GEN-LAST:event_sliderStateChanged

    private void btnBrowseType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseType1ActionPerformed
        
        // Get filechooser result.
        int returnVal = chooser.showOpenDialog(this);
        
        // Check if selected file is an image.
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            // Check if selected file is an image.
            File file = chooser.getSelectedFile();
            
            // Get selected image's full path.
            filepath = file.getAbsolutePath();
            
            // Process selected image to panel.
            setImagePanel(file.getAbsolutePath(), 0);
            
            // Reset zoom integer value.
            zoom = 0;
        }
        
    }//GEN-LAST:event_btnBrowseType1ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
        // Crop displayed image
        imageCrop();
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnZoomRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomRefreshActionPerformed
        
        // Check if has a selected image.
        if(!this.filepath.trim().isEmpty()) {
            
            // Check if current zoom value is not 0
            if(this.zoom != 0) {
                
                // Reset zoom integer value.
                this.zoom = 0;
                
                // Process selected image to panel.
                setImagePanel(this.filepath, this.zoom);
            }
        }
        
    }//GEN-LAST:event_btnZoomRefreshActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        
        // Check if has a selected image.
        if(!this.filepath.trim().isEmpty()) {
            
            // Add  image zoom value.
            this.zoom += 100;
            
            // Limit only to maximum zoom.
            if(this.zoom > 1000) { this.zoom = 1000; return; }
            
            // Process selected image to panel.
            setImagePanel(this.filepath, this.zoom);
        }
        
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        
        // Check if has a selected image.
        if(!this.filepath.trim().isEmpty()) {
            
            // Minus image zoom value.
            this.zoom -= 100;
            
            // Limit should not be lower than 0.
            if(this.zoom < 0) { this.zoom = 0; return; }
            
            // Process selected image to panel.
            setImagePanel(this.filepath, this.zoom);
        }
        
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnBrowseType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseType2ActionPerformed
        
        // Get filechooser result.
        int returnVal = chooser.showOpenDialog(this);
        
        // Check if selected file is an image.
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            // Check if selected file is an image.
            File file = chooser.getSelectedFile();
            
            // Get selected image's full path.
            filepath = file.getAbsolutePath();
            
            // Process selected image to panel.
            setImagePanel(file.getAbsolutePath(), 0);
            
            // Reset zoom integer value.
            zoom = 0;
        }
        
    }//GEN-LAST:event_btnBrowseType2ActionPerformed

    public void setImagePanel(String path, int zoom) {
        
        // If no image given.
        if(path.trim().isEmpty()) { return; }
        
        // Reset zoom slider
        slider.setValue(0); // Reset values
        slider.setEnabled(false); // Reset enability
        
        boolean additional_fill = false; // Variable that check if image need's additional value to fit panel
        javaxt.io.Image imageIO_src_1st = new javaxt.io.Image(path); // Get and set image from selected path
        javaxt.io.Image imageIO_src_2nd = imageIO_src_1st; // Get and set secondary image from selected path
        
        // Modify image size
        if(imageIO_src_1st.getHeight() >= imageIO_src_1st.getWidth()) {
            imageIO_src_1st.setWidth(classImageAreaPanelv2.getWidth() + zoom);
        } else {
            imageIO_src_1st.setHeight(classImageAreaPanelv2.getHeight() + zoom);
        }

        // Check if needs to be modified further based on height
        if(imageIO_src_1st.getWidth() == classImageAreaPanelv2.getWidth() && classImageAreaPanelv2.getHeight() > imageIO_src_1st.getHeight()) {
            imageIO_src_2nd.setHeight(classImageAreaPanelv2.getHeight() + zoom);
            additional_fill = true; // Tick this
        }

        // Check if needs to be modified further based on width
        if(imageIO_src_1st.getHeight()== classImageAreaPanelv2.getHeight() && classImageAreaPanelv2.getWidth()> imageIO_src_1st.getWidth()) {
            imageIO_src_2nd.setWidth(classImageAreaPanelv2.getWidth() + zoom);
            additional_fill = true; // Tick this
        }
        
        // Check what image to use based on image fill
        if(!additional_fill) {
            // If does not need additional adjustment to fill panel
            classImageAreaPanelv2.setImage(imageIO_src_1st.getBufferedImage());
        } else {
            // else, use modified image
            classImageAreaPanelv2.setImage(imageIO_src_2nd.getBufferedImage());
        }
        
        this.repaint(); // Trigger panel repaint
        slider.setEnabled(true);
        
    }

    public void setPanelControls(int cardType) {
        
        CardLayout cardLayout = (CardLayout) panelControls.getLayout();
        
        switch(cardType) {
            case 0:
                cardLayout.show(panelControls, "card_type_0");
                break;
            case 1:
                cardLayout.show(panelControls, "card_type_1");
                break;
            case 2:
                cardLayout.show(panelControls, "card_type_2");
                break;
            default:
                cardLayout.show(panelControls, "card_type_0");
                break;
        }
        
    }

    public void setPanelMode(int cardType) {
        
        CardLayout cardLayout = (CardLayout) panelMode.getLayout();
        
        switch(cardType) {
            case 0:
                cardLayout.show(panelMode, "card_mode_0");
                break;
            case 1:
                cardLayout.show(panelMode, "card_mode_1");
                break;
            default:
                cardLayout.show(panelMode, "card_mode_0");
                break;
        }
        
    }

    public void imageCrop() {
        
        classImageAreaPanelv2.crop();
        this.repaint(); // Trigger panel repaint
        
    }
    
    /**
     * Set an extension to the cropped image when saved.
     * 
     * @param ext
     */
    public void setCropExtension(String ext) {
        
        classImageAreaPanelv2.imageextension = ext;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseType0;
    private javax.swing.JButton btnBrowseType1;
    private javax.swing.JButton btnBrowseType2;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JButton btnZoomRefresh;
    private img_emp_src.ClassImageAreaPanelv2 classImageAreaPanelv2;
    private javax.swing.JPanel panelControlType0;
    private javax.swing.JPanel panelControlType1;
    private javax.swing.JPanel panelControlType2;
    private javax.swing.JPanel panelControls;
    private javax.swing.JPanel panelMode;
    private javax.swing.JPanel panelModeFull;
    private javax.swing.JPanel panelModeSome;
    private javax.swing.JPanel panelZoom;
    private javax.swing.JPanel panelZoomRefresh;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
