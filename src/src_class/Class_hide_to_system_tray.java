/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author egrubellano
 */
public class Class_hide_to_system_tray {

    TrayIcon trayIcon;
    SystemTray tray;
    JFrame usedFrame;
    
    public void frameSystemTrayOption(final JFrame frame, final JTextField txtfld){
        
        usedFrame = frame;
        
        ImageIcon iconUsed = new javax.swing.ImageIcon(getClass().getResource("/img_src/icon_16_lock.png"));
        Image imageUsed = iconUsed.getImage();
        
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Re-Open");
            defaultItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tray.remove(trayIcon);
                    frame.setVisible(true);
                }
            });
            popup.add(defaultItem);
            defaultItem = new MenuItem("Close");
            ActionListener exitListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int exitOption = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?\n", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
                    switch(exitOption){

                        case 0:
                            System.exit(0);
                            break;

                        case 1:
                            break;
                    }
                }
            };
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            
            trayIcon = new TrayIcon(imageUsed, "HIDING: Human Resource Information System", popup);
            trayIcon.setImageAutoSize(true);
            
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tray.remove(trayIcon);
                    frame.setVisible(true);
                    if(txtfld != null){
                        txtfld.requestFocus();
                    }
                }
            });
            
        } else {
            JOptionPane.showMessageDialog(frame, "System Tray Not Supported.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void setButtonToBeHidden(){
        
        try {
            tray.add(trayIcon);
            usedFrame.setVisible(false);
        } catch (AWTException ex) {
            System.out.println("ERROR: Occured while hiding system to tray: " + ex.getMessage());
        }
        
    }

}
