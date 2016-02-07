/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * @author blacqueous
 * This class defines a specialized panel for displaying a captured image.
 */
public class ImageArea extends JPanel {

    /**
     * Stroke-defined outline of selection rectangle.
     */
    private BasicStroke bs;

    /**
     * A gradient paint is used to create a distinctive-looking selection
     * rectangle outline.
     */
    private GradientPaint gp;

    /**
     * Displayed image`s Image object, which is actually a BufferedImage.
     */
    private Image image;

    /**
     * Cropped Image object, which is actually a BufferedImage.
     */
    private Image croppedimage;

    /**
     * Mouse coordinates when mouse button pressed.
     */
    private int srcx, srcy;

    /**
     * Latest mouse coordinates during drag operation.
     */
    private int destx, desty;

    /**
     * Location and extents of selection rectangle.
     */
    private Rectangle rectSelection;

    /**
     * Construct an ImageArea component.
     */
    public ImageArea() {
       // Create a selection Rectangle. It's better to create one Rectangle
       // here than a Rectangle each time paintComponent() is called, to reduce
       // unnecessary object creation.
        rectSelection = new Rectangle();

       // Define the stroke for drawing selection rectangle outline.
        bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{1, 0}, 0);

       // Define the gradient paint for coloring selection rectangle outline.
        gp = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.white, true);
       // Install a mouse listener that sets things up for a selection drag.

        MouseListener ml;
        ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               // When you start Capture, there is no captured image.
               // Therefore, it makes no sense to try and select a subimage.
               // This is the reason for the if (image == null) test.
                if (image == null) {
                    return;
                }

                destx = srcx = e.getX();
                desty = srcy = e.getY();

                repaint();
            }
        };
        addMouseListener(ml);

       // Install a mouse motion listener to update the selection rectangle
       // during drag operations.
        MouseMotionListener mml;
        mml = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
               // When you start Capture, there is no captured image.
               // Therefore, it makes no sense to try and select a
               // subimage. This is the reason for the if (image == null)
               // test.
                if (image == null) {
                    return;
                }
                
               /**
                * Well this works
                */
                destx = e.getX();

                if (srcx > e.getX()) {
                    desty = srcy + (srcx - e.getX());
                } else if (e.getX() > srcx) {
                    desty = srcy + (e.getX() - srcx);
                }

               /** 
                * To be improved
                */
                //  if(e.getX() > e.getY()) {
                //      destx = e.getX();
                //
                //      if (srcx > e.getX()) {
                //          desty = srcy + (srcx - e.getX());
                //      } else if (e.getX() > srcx) {
                //          desty = srcy + (e.getX() - srcx);
                //      }
                //  } else if(e.getY() > e.getX()) {
                //      desty = e.getY();
                //
                //      if (srcy > e.getY()) {
                //          destx = srcx + (srcy - e.getY());
                //      } else if (e.getY() > srcy) {
                //          destx = srcx + (e.getY() - srcy);
                //      }
                //  }
                
                repaint();
            }
        };
        addMouseMotionListener(mml);
    }

    /**
     * Crop the image to the dimensions of the selection rectangle.
     *
     * @return true if cropping succeeded
     */
    public boolean crop() {
       // There is nothing to crop if the selection rectangle is only a single
       // point.
        if (srcx == destx && srcy == desty) {
            return true;
        }
        
       // Assume success.
        boolean succeeded = true;
        
       // Compute upper-left and lower-right coordinates for selection rectangle
       // corners.
        int x1 = (srcx < destx) ? srcx : destx;
        int y1 = (srcy < desty) ? srcy : desty;
        
        int x2 = (srcx > destx) ? srcx : destx;
        int y2 = (srcy > desty) ? srcy : desty;
        
       // Compute width and height of selection rectangle.
        int width = (x2 - x1) + 1;
        int height = (y2 - y1) + 1;

       // Create a buffer to hold cropped image.
        BufferedImage biCrop = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = biCrop.createGraphics();
        
       // Perform the crop operation.
        try {
            BufferedImage bi = (BufferedImage) image;
            BufferedImage bi2 = bi.getSubimage(x1, y1, width, height);
            g2d.drawImage(bi2, null, 0, 0);
        } catch (RasterFormatException e) {
            succeeded = false;
        }
        
        g2d.dispose();
        
        if (succeeded) {
            
            String img_path = getClass().getResource("/img_emp_src/").getFile();
            File img_path_file = new File(img_path);
            try {
                 javaxt.io.Image images = new javaxt.io.Image(biCrop);
                 images.setWidth(100); //set width, adjusts height to maintain aspect ratio
                 images.setHeight(100); //set height, adjusts width to maintain aspect ratio
                 images.resize(100, 100);

                 ImageIO.write(images.getBufferedImage(), "jpg", new File(img_path_file.getAbsolutePath() + "\\1.jpg"));

                 croppedimage = images.getBufferedImage();

            } catch (IOException ex) {
                 // handle exception...
            }
            
//            setImage(biCrop); // Implicitly remove selection rectangle.
        } else {
           // Prepare to remove selection rectangle.
            srcx = destx;
            srcy = desty;
            
           // Explicitly remove selection rectangle.
            repaint();
        }
        return succeeded;
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
     * Return the current image.
     *
     * @return Image reference to current image
     */
    public Image getCroppedImage() {
        return croppedimage;
    }

    /**
     * Repaint the ImageArea with the current image`s pixels.
     *
     * @param g graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
       // Repaint the component's background.
        super.paintComponent(g);
        
       // If an image has been defined, draw that image using the Component
       // layer of this ImageArea object as the ImageObserver.
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
        
       // Draw the selection rectangle if present.
        if (srcx != destx || srcy != desty) {
           // Compute upper-left and lower-right coordinates for selection
           // rectangle corners.
            int x1 = (srcx < destx) ? srcx : destx;
            int y1 = (srcy < desty) ? srcy : desty;
            
            int x2 = (srcx > destx) ? srcx : destx;
            int y2 = (srcy > desty) ? srcy : desty;
            
           // Establish selection rectangle origin.
            rectSelection.x = x1;
            rectSelection.y = y1;
            
           // Establish selection rectangle extents.
            rectSelection.width = (x2 - x1) + 1;
            rectSelection.height = (y2 - y1) + 1;
            
           // Draw selection rectangle.
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0, 0, 255, 20));
            g2d.fill(rectSelection);
            g2d.setStroke(bs);
            g2d.setPaint(gp);
            g2d.draw(rectSelection);
        }
        
    }

    /**
     * Establish a new image and update the display.
     *
     * @param image new image`s Image reference
     */
    public void setImage(Image image) {
        
       // Save the image for later repaint.
        this.image = image;
        
       // Set this panel's preferred size to the image`s size, to influence the
       // display of scrollbars.
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        
       // Present scrollbars as necessary.
        revalidate();
        
       // Prepare to remove any selection rectangle.
        srcx = destx;
        srcy = desty;
        
       // Update the image displayed on the panel.
        repaint();
        
    }
    
}
