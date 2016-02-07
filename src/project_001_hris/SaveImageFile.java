/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author FTSvirus
 */
public class SaveImageFile {

    public SaveImageFile() {
        final JFrame frame = new JFrame("Save Image");

        JButton saveImage = new JButton("Browse");
        saveImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG, GIF, and PNG Images", "jpg", "gif", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(frame);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    System.out.println("You chose to open this file: " + file.getName());
                    BufferedImage image;
                    
                    String img_path = getClass().getResource("/img_emp_src/").getFile();
                    File img_path_file = new File(img_path);
                    
                    try {
                        image = ImageIO.read(file);
                        ImageIO.write(image, "jpg", new File(img_path_file.getAbsolutePath() + "\\" + file.getName()));
                        System.out.println("Saving done...");
                    } catch (IOException ex) {
                        Logger.getLogger(SaveImageFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        frame.add(saveImage);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SaveImageFile saveImageFile = new SaveImageFile();
            }
        });
    }
}
