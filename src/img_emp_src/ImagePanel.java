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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author blacqueous
 */
public class ImagePanel extends JPanel {

    /**
     * Displayed BufferedImage.
     */
    private BufferedImage image;
    
    /**
     * Displayed image path. This is a String variable.
     */
    private String path = getClass().getResource("/img_emp_src/Galaxy2.jpg").getFile();

    /**
     * Construct an ImagePanel component.
     */
    public ImagePanel() {
        String img_path = getClass().getResource("/img_emp_src/").getFile();
        File img_path_file = new File(img_path);
       try {
           image = ImageIO.read(new File(path));
           
            javaxt.io.Image images = new javaxt.io.Image(image);
            images.setWidth(100); //set width, adjusts height to maintain aspect ratio
            images.setHeight(100); //set height, adjusts width to maintain aspect ratio
            images.resize(100, 100);

            ImageIO.write(images.getBufferedImage(), "jpg", new File(img_path_file.getAbsolutePath() + "\\1.jpg"));
            
            image = images.getBufferedImage();
                        
       } catch (IOException ex) {
            // handle exception...
       }
    }

    /**
     * Repaint the ImageArea with the current image's pixels.
     *
     * @param g graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    /**
     * Establish a new image and update the display.
     *
     * @param bImage new image's Image reference
     */
    public void setImage(BufferedImage bImage) {
        this.image = bImage;
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        revalidate();
        repaint();
    }

    /**
     * Return the current image.
     *
     * @return Image reference to current image
     */
    public Image getImage() {
        return image;
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