/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * @author blacqueous
 * This class defines a specialized panel for displaying a captured image.
 */
public class ClassImageAreaPanel extends JPanel {
    
    /**
     * Displayed BufferedImage.
     */
    private BufferedImage bimage;
    
    /**
     * Displayed image path. This is a String variable.
     */
    private String path = getClass().getResource("/img_emp_src/img_galaxy_2.jpg").getFile();
    
    /**
     * Construct an ImageArea component.
     */
    public ClassImageAreaPanel() {
       
////        String img_path = getClass().getResource("/img_emp_src/").getFile();
////        File img_path_file = new File(img_path);
//        
//        try {
//            bimage = ImageIO.read(new File(path));
//
//            javaxt.io.Image images = new javaxt.io.Image(bimage);
//            images.setWidth(100); // Set width, adjusts height to maintain aspect ratio
//            images.setHeight(100); // Set height, adjusts width to maintain aspect ratio
////            images.resize(100, 100);
//
////            ImageIO.write(images.getBufferedImage(), "jpg", new File(img_path_file.getAbsolutePath() + "\\1.jpg"));
//
//            bimage = images.getBufferedImage();
//                        
//        } catch (IOException ex) {
//             // handle exception...
//        }
    }
    
    /**
     * Repaint the ImageArea with the current image`s pixels.
     *
     * @param g graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bimage, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    /**
     * Establish a new image and update the display.
     *
     * @param image new image`s Image reference
     */
    public void setImage(BufferedImage image) {
        this.bimage = image;
        setPreferredSize(new Dimension(100, 100));
        revalidate();
        repaint();
    }
    
    /**
     * Return the current image.
     *
     * @return Image reference to current image
     */
    public Image getImage() {
        return bimage;
    }
    
    /**
     * Establish a new file path to be used as image
     *
     * @param new_path  new image File path
     */
    public void setPath(String new_path) {
        this.path = new_path;
    }
    
}
