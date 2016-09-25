/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author blacqueous
 * This class defines a specialized panel for displaying a captured image.
 */
public class ClassImageCropPanel extends JPanel {
    
    /**
     * Stroke-defined outline of selection rectangle.
     */
    private final BasicStroke bs;
    
    /**
     * A gradient paint is used to create a distinctive-looking selection
     * rectangle outline.
     */
    private final GradientPaint gp;
    
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
    private int mainsrcx, mainsrcy;
    
    /**
     * Latest mouse coordinates during drag operation.
     */
    private int destx, desty;
    private int maindestx, maindesty;
    
    /**
     * Location and extents of selection rectangle.
     */
    private final Rectangle rectSelection;
    
    /**
     * MouseAdapter for JPanel cropping action.
     */
    
    private final int shortSideMax = 500;
    private final int longSideMax = 500;
    float newHeight, newWidth;

    public int panelSize = 300;

    /**
     * Construct an ImageArea component.
     */
    public ClassImageCropPanel() {
        // Create a selection Rectangle. It's better to create one Rectangle
        // here than a Rectangle each time paintComponent() is called, to reduce
        // unnecessary object creation.
        rectSelection = new Rectangle();

        // Define the stroke for drawing selection rectangle outline.
        bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{1, 0}, 0);

        // Define the gradient paint for coloring selection rectangle outline.
        gp = new GradientPaint(0.0f, 0.0f, new Color(240, 240, 240), 0.0f, 0.0f, new Color(240, 240, 240), true);
        
        // Set default crop selection size
        mainsrcx = srcx = 1;
        mainsrcy = srcy = 1;
        maindestx = destx = panelSize - 3;
        maindesty = desty = panelSize - 3;

        repaint();

        // Install a mouse listener that sets things up for a selection drag.
        MouseListener ml;
        ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                // When you start Capture, there is no captured image.
                // Therefore, it makes no sense to try and select a subimage.
                // This is the reason for the if (image == null) test.
                if (image == null) {
                    return;
                }
                
//                if(mainsrcx==0 && mainsrcy==0 && maindestx==0 && maindesty==0){
                    mainsrcx = srcx = me.getX()-((int)panelSize/2);
                    mainsrcy = srcy = me.getY()-((int)panelSize/2);
                    maindestx = destx = me.getX()+((int)panelSize/2);
                    maindesty = desty = me.getY()+((int)panelSize/2);
//                } else {
//                    srcx = me.getX()-(mainsrcx);
//                    srcy = me.getY()-(mainsrcy);
//                    destx = me.getX()+(maindestx);
//                    desty = me.getY()+(maindesty);
//                }
//        mainsrcx = srcx = 1;
//        mainsrcy = srcy = 1;
//        maindestx = destx = panelSize - 3;
//        maindesty = desty = panelSize - 3;
            }
        };
        addMouseListener(ml);

       // Install a mouse motion listener to update the selection rectangle
       // during drag operations.
        MouseMotionListener mml;
        mml = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                // When you start Capture, there is no captured image.
                // Therefore, it makes no sense to try and select a
                // subimage. This is the reason for the if (image == null)
                // test.
                if (image == null) {
                    return;
                }
                
//                mainsrcx = srcx = me.getX()-((int)newHeight/2);
//                mainsrcy = srcy = me.getY()-((int)newHeight/2);
//                maindestx = destx = me.getX()+((int)newHeight/2);
//                maindesty = desty = me.getY()+((int)newHeight/2);
                
                if((me.getX()-((int)panelSize/2)) >= 0) {
                    mainsrcx = srcx = me.getX()-((int)panelSize/2);
                    maindestx = destx = me.getX()+((int)panelSize/2);
                }
                mainsrcy = srcy = me.getY()-((int)panelSize/2);
                maindesty = desty = me.getY()+((int)panelSize/2);
System.out.println(mainsrcx);
System.out.println(mainsrcy);
System.out.println(maindestx);
System.out.println(maindesty);

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
        
        // Change to image to circle
//        g2d.setClip(new Ellipse2D.Float(0, 0, width, height));
        
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.clip(new Ellipse2D.Float(0, 0, width, height));
        
        
//        Area outside = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
//    	outside.subtract(new Area(g2d.getClipBounds()));
//        
//        g2d.clip(outside);
//        g2d.setColor(new Color(255, 255, 255, 0));
//        g2d.fillRect(x1, y1, width, height);
        
        // Perform the crop operation.
        try {
            BufferedImage bi = (BufferedImage) image;
            BufferedImage bi2 = bi.getSubimage(x1, y1, width, height);
            g2d.drawImage(bi2, null, 0, 0);
//            g2d.drawRoundRect(0, 0, width, height, 100, 100);
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
                
                ImageIO.write(images.getBufferedImage(), "png", new File(img_path_file.getAbsolutePath() + "\\1.png"));
                
                croppedimage = images.getBufferedImage();

            } catch (IOException ex) {
                // handle exception...
            }
            
//            destx = srcx = 0;
//            desty = srcy = 0;
            repaint();
            
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
            rectSelection.x = x1-1;
            rectSelection.y = y1-1;
            
            // Establish selection rectangle extents.
            rectSelection.width = (x2 - x1) + 10;
            rectSelection.height = (y2 - y1) + 10;
            
            // Draw selection rectangle.
            Graphics2D g2d = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(x1, y1, ((x2-x1)+1), ((y2-y1)+1));
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

//            Area outter = new Area(new Rectangle(rectSelection.x, rectSelection.y, rectSelection.width, rectSelection.height));
            Area outter = new Area(new Rectangle(0, 0, 510, 510));
            outter.subtract(new Area(circle));
            g2d.setColor(new Color(255, 255, 255));
            g2d.fill(outter);

//            g2d.setStroke(bs);
//            g2d.setPaint(gp);
//            
//            g2d.drawOval(x1, y1, ((x2-x1)+1), ((y2-y1)+1));

        }
    }

    /**
     * Establish a new image and update the display.
     *
     * @param image new image`s Image reference
     */
    public void setImage(Image image) {
        // Save the image for later repaint.
//        this.image = image;
        
        // Set this panel's preferred size to the image`s size, to influence the
        // display of scrollbars.
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        resizeImage(image);
        
        BufferedImage resizedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        
        int indent = (this.getHeight()-(int) newHeight)/2;
        g.drawImage(image, 0, indent, (int) newWidth, (int) newHeight, null);
System.out.println(newHeight);
System.out.println(newWidth);
        g.dispose();

        this.image = resizedImage;
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Prepare to remove any selection rectangle.
//        srcx = destx;
//        srcy = desty;
        
        // Update the image displayed on the panel.
        repaint();
        
    }
    
    public void resizeImage(Image image) {
        float wRatio, hRatio, resizeRatio;
        if (image.getWidth(this) >= image.getHeight(this)) {
            if (image.getWidth(this) <= longSideMax && image.getHeight(this) <= shortSideMax) {
        //            return image;  // no resizing required
                System.out.println("Must return!!!");
            }
            wRatio = ((float) longSideMax) / image.getWidth(this);
            hRatio = ((float) shortSideMax) / image.getWidth(this);
        } else {
            if (image.getHeight(this) <= longSideMax && image.getWidth(this) <= shortSideMax) {
        //            return image; // no resizing required
                System.out.println("Must return!!!");
            }
            wRatio = ((float) shortSideMax) / image.getWidth(this);
            hRatio = ((float) longSideMax) / image.getHeight(this);
        }

        // hRatio and wRatio now have the scaling factors for height and width.
        // You want the smallest of the two to ensure that the resulting image
        // fits in the desired frame and maintains the aspect ratio.
        resizeRatio = Math.min(wRatio, hRatio);

        newHeight = image.getHeight(this) * resizeRatio;
        newWidth = image.getWidth(this) * resizeRatio;
        
        // Now call function to resize original image to [newWidth, newHeight]
        // and return the result.
    }
    
    public void resizeCropSelection(int newValue) {
        
        srcx = mainsrcx+(100-newValue);
        srcy = mainsrcy+(100-newValue);
        destx = maindestx-(100-newValue);
        desty = maindesty-(100-newValue);
        repaint();
        
    }
    
}
