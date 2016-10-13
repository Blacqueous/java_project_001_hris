/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.JPanel;
import org.imgscalr.Scalr;

/**
 * @author blacqueous
 * This class defines a specialized panel for displaying a captured image.
 */
public class ClassImageAreaPanelv2 extends JPanel {
    
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
    private static Image image;
    private static Image imagesource;
    
    /**
     * Cropped Image object, which is actually a BufferedImage.
     */
    private Image croppedimage;
    
    /**
     * Mouse coordinates when mouse button pressed.
     */
    public static int srcx, srcy = 0;
    public static int mainsrcx, mainsrcy  = 0;
    
    /**
     * Latest mouse coordinates during drag operation.
     */
    private static int destx, desty = 0 ;
    private static int maindestx, maindesty = 0;
    
    /**
     * Location and extents of selection rectangle.
     */
    private final Rectangle rectSelection;
    
    /**
     * Crop image extension string.
     */
    public String imageextension = "jpg";
    
    private int zoomvalue = 0;
    
    /**
     * Construct an ImageArea component.
     */
    public ClassImageAreaPanelv2() {
        // Create a selection Rectangle. It's better to create one Rectangle
        // here than a Rectangle each time paintComponent() is called, to reduce
        // unnecessary object creation.
        rectSelection = new Rectangle();

        // Define the stroke for drawing selection rectangle outline.
        bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{1, 0}, 0);

        // Define the gradient paint for coloring selection rectangle outline.
        gp = new GradientPaint(0.0f, 0.0f, new Color(240, 240, 240), 0.0f, 0.0f, new Color(240, 240, 240), true);
        
        // Set default crop selection size.
        mainsrcx = srcx = 0;
        mainsrcy = srcy = 0;
        maindestx = destx = 0;
        maindesty = desty = 0;
    }
    
    /**
     * Construct the component with added listeners and options.
     * 
     * @return created ClassImageAreaPanelv2
     */
    public static ClassImageAreaPanelv2 create(){
        
        ClassImageAreaPanelv2 panel = new ClassImageAreaPanelv2();
        
        // Create a mouse listener that sets things up for a selection drag.
        MouseListener ml;
        ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // When you start Capture, there is no captured image.
                // Therefore, it makes no sense to try and select a subimage.
                // This is the reason for the if image is not existing.
                if (image == null) { return; }
                
                // mainsrcx = srcx = e.getX() - ((int)panelSize/2);
                // mainsrcy = srcy = e.getY() - ((int)panelSize/2);
                // maindestx = destx = e.getX() + ((int)panelSize/2);
                // maindesty = desty = e.getY() + ((int)panelSize/2);
                
                e.getComponent().repaint();
            }
        };
        // Install mouse listener.
        // panel.addMouseListener(ml);

        // Create a mouse motion listener to update the selection area during
        // drag operations.
        MouseMotionListener mml;
        mml = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // When you start Capture, there is no captured image.
                // Therefore, it makes no sense to try and select a subimage.
                // This is the reason for the if image is not existing.
                if (image == null) { return; }
                
                // mainsrcx = srcx = e.getX() - ((int)newHeight/2);
                // mainsrcy = srcy = e.getY() - ((int)newHeight/2);
                // maindestx = destx = e.getX() + ((int)newHeight/2);
                // maindesty = desty = e.getY() + ((int)newHeight/2);
                
                e.getComponent().repaint();
            } 
        };
        // Install mouse motion listener.
        // panel.addMouseMotionListener(mml);
        
        // Create a resize listener to update the selection area size during 
        // resize operations.
        ComponentAdapter resizeListener;
        resizeListener = new ComponentAdapter() {
            @Override
            public  void componentResized(ComponentEvent e) {
                // Recalculate the selection area variables.
                if(e.getComponent().getHeight() >= e.getComponent().getWidth()) {
                    mainsrcx = srcx = 0;
                    mainsrcy = srcy = (e.getComponent().getHeight() / 2) - (e.getComponent().getWidth() / 2);
                    maindestx = destx = e.getComponent().getWidth();
                    maindesty = desty = e.getComponent().getWidth() + mainsrcy;
                } else {
                    mainsrcx = srcx = (e.getComponent().getWidth() / 2) - (e.getComponent().getHeight() / 2);
                    mainsrcy = srcy = 0;
                    maindestx = destx = e.getComponent().getHeight() + mainsrcx;
                    maindesty = desty = e.getComponent().getHeight();
                }
            }
        };
        // Install resize listener
        // panel.addComponentListener(resizeListener);
        
        // Repaint the panel with the listeners.
        panel.repaint();
        
        // Return customized panel.
        return panel;
    }

    /**
     * Crop the image to the dimensions of the selection rectangle.
     *
     * @return true if cropping succeeded
     */
    public boolean crop() {
        // There is nothing to crop if the selection rectangle is only a single
        // point.
        if (srcx == destx && srcy == desty) { return true; }
        
        // Assume success.
        boolean succeeded = true;
        
        // Compute upper-left and lower-right coordinates for selection rectangle
        // corners.
        int x1 = (srcx < destx) ? srcx : destx;
        int y1 = (srcy < desty) ? srcy : desty;
        
        int x2 = (srcx > destx) ? srcx : destx;
        int y2 = (srcy > desty) ? srcy : desty;
        
        // Compute width and height of selection rectangle.
        int width = (x2 - x1);
        int height = (y2 - y1);
        
        
// Scale in respect to width or height?
Scalr.Mode scaleMode;

// find out which side is the shortest
int maxSize = 0;
if (imagesource.getHeight(this) > imagesource.getWidth(this)) {
    // scale to width
    scaleMode = Scalr.Mode.FIT_TO_WIDTH;
    maxSize = imagesource.getWidth(this) - zoomvalue;
} else {
    scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
    maxSize = imagesource.getHeight(this) - zoomvalue;
}

BufferedImage outputImage = Scalr.resize((BufferedImage)imagesource, Scalr.Method.ULTRA_QUALITY, scaleMode, maxSize);

int indentH = (this.getHeight() - outputImage.getHeight()) / 2;
int indentW = (this.getWidth() - outputImage.getWidth()) / 2;

BufferedImage resizedImage = new BufferedImage(outputImage.getWidth(), outputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g = resizedImage.createGraphics();
g.drawImage(outputImage, indentW, indentH, outputImage.getWidth(), outputImage.getHeight(), null);
g.dispose();

image = resizedImage;
        
        // Create a buffer to hold cropped image.
        BufferedImage biCrop = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = biCrop.createGraphics();
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(x1, y1, width, height, 0, 0);
        
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
                images.resize(width, height);
                
                ImageIO.write(images.getBufferedImage(), imageextension, new File(img_path_file.getAbsolutePath() + "\\1." + imageextension));
                
                croppedimage = images.getBufferedImage();
            } catch (IOException ex) {
                // handle exception...
            }
        } else {
            // Prepare to remove selection rectangle.
            srcx = destx;
            srcy = desty;
        }
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
        
        return succeeded;
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
            rectSelection.width = (x2 - x1);
            rectSelection.height = (y2 - y1);
            
        }
    }
    
    /**
     * Establish a new image and update the display.
     *
     * @param img new image`s Image reference
     */
    public void setImage(Image img) {
        // Save the image for later repaint.
        image = img;
        imagesource = image;
        
        int indentH = (this.getHeight()-image.getHeight(this)) / 2;
        int indentW = (this.getWidth()-image.getWidth(this)) / 2;
        
        BufferedImage resizedImage = new BufferedImage(image.getWidth(this), image.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, indentW, indentH, image.getWidth(this), image.getHeight(this), null);
        g.dispose();
        
        // Set resized image as main image.
        image = resizedImage;
        
        // Set image crop size
        if(this.getHeight() >= this.getWidth()) {
            mainsrcx = srcx = 0;
            mainsrcy = srcy = (this.getHeight() / 2) - (this.getWidth() / 2);
            maindestx = destx = (this.getWidth());
            maindesty = desty = (this.getWidth() + mainsrcy);
        } else {
            mainsrcx = srcx = (this.getWidth() / 2) - (this.getHeight() / 2);
            mainsrcy = srcy = 0;
            maindestx = destx = (this.getHeight() + mainsrcx);
            maindesty = desty = (this.getHeight());
        }
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
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
     * Return the cropped image.
     *
     * @return Image reference to current image
     */
    public Image getCroppedImage() {
        return croppedimage;
    }
    
    public void resizeImage(int resizeValue, boolean smooth) {
        // Check if an image exists before resizing.
        if(imagesource == null) { return; }
        
        zoomvalue = resizeValue;
        
        if(smooth) { // If using a slider
            
//            // Check if resize value is not negative.
//            if(resizeValue <= 0) {
//                resizeValue = 0;
//            }
//
//            // Save the image for later repaint.
//            Image sourceImage = imagesource;
//
//            javaxt.io.Image imageIO = new javaxt.io.Image((BufferedImage)sourceImage);
//
//            if(imageIO.getHeight() >= imageIO.getWidth()) {
//                imageIO.setWidth(imageIO.getWidth() + resizeValue);
//            } else {
//                imageIO.setHeight(imageIO.getHeight() + resizeValue);
//            }
//
//            int indentH = (this.getHeight() - imageIO.getHeight()) / 2;
//            int indentW = (this.getWidth() - imageIO.getWidth()) / 2;
//
//            BufferedImage resizedImage = new BufferedImage(imageIO.getWidth(), imageIO.getHeight(), BufferedImage.TYPE_INT_ARGB);
//            Graphics2D g = resizedImage.createGraphics();
//            g.drawImage(imageIO.getImage(), indentW, indentH, imageIO.getWidth(), imageIO.getHeight(), null);
//            g.dispose();
//
//            image = resizedImage;
//
//            int longSideMax, shortSideMax;
//            
//            if(image.getHeight(this) >= image.getWidth(this)) {
//                longSideMax = image.getHeight(this);
//                shortSideMax = image.getWidth(this);
//            } else {
//                longSideMax = image.getWidth(this);
//                shortSideMax = image.getHeight(this);
//            }
//
//System.out.println(longSideMax);
//System.out.println(shortSideMax);
////return;
//
//            float wRatio, hRatio, resizeRatio;
//
//            if (image.getWidth(this) >= image.getHeight(this)) {
//                if (image.getWidth(this) <= longSideMax && image.getHeight(this) <= shortSideMax) {
//                    // return image;  // no resizing required
//                    // System.out.println("Must return!!!");
//                }
//                wRatio = ((float) longSideMax) / image.getWidth(this);
//                hRatio = ((float) shortSideMax) / image.getWidth(this);
//            } else {
//                if (image.getHeight(this) <= longSideMax && image.getWidth(this) <= shortSideMax) {
//                    // return image; // no resizing required
//                    // System.out.println("Must return!!!");
//                }
//                wRatio = ((float) shortSideMax) / image.getWidth(this);
//                hRatio = ((float) longSideMax) / image.getHeight(this);
//            }
//
////            // hRatio and wRatio now have the scaling factors for height and width.
////            // You want the smallest of the two to ensure that the resulting image
////            // fits in the desired frame and maintains the aspect ratio.
//            resizeRatio = Math.min(wRatio, hRatio);
////            // return resizeRatio;
//System.out.println(resizeRatio);
////            // Now call function to resize original image to [newWidth, newHeight]
////            // and return the result.
////            int newHeight = (int)(image.getHeight(this) * resizeRatio) - resizeValue;
////            int newWidth = (int)(image.getWidth(this) * resizeRatio) - resizeValue;
//            int newHeight = (int)((image.getHeight(this) - resizeValue) * resizeRatio);
//            int newWidth = (int)((image.getWidth(this) - resizeValue) * resizeRatio);
//System.out.println("nh : " + newHeight);
//System.out.println("nw : " + newWidth);
//
//System.out.println("ig : " + image.getHeight(this));
//System.out.println("iw : " + image.getWidth(this));
////return;

            // Scale in respect to width or height?
            Scalr.Mode scaleMode;

            // find out which side is the shortest
            int maxSize = 0;
            if (imagesource.getHeight(this) > imagesource.getWidth(this)) {
                // scale to width
                scaleMode = Scalr.Mode.FIT_TO_WIDTH;
                maxSize = imagesource.getWidth(this) - resizeValue;
            } else {
                scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
                maxSize = imagesource.getHeight(this) - resizeValue;
            }
            

            BufferedImage outputImage = Scalr.resize((BufferedImage)imagesource, Scalr.Method.SPEED, scaleMode, maxSize);
            
            int indentH = (this.getHeight() - outputImage.getHeight()) / 2;
            int indentW = (this.getWidth() - outputImage.getWidth()) / 2;
            
            BufferedImage resizedImage = new BufferedImage(outputImage.getWidth(), outputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            // g.drawImage(image, 0, 0, image.getWidth(this) + (0 - resizeValue), image.getHeight(this) + ( 0 - resizeValue), null);
            g.drawImage(outputImage, indentW, indentH, outputImage.getWidth(), outputImage.getHeight(), null);
            g.dispose();
            
            image = resizedImage;
            
        } else { // If using buttons
            
            // Check if resize value is not negative.
            if(resizeValue <= 0) {
                resizeValue = 0;
            }

            // Save the image for later repaint.
            Image sourceImage = imagesource;

            javaxt.io.Image imageIO = new javaxt.io.Image((BufferedImage)sourceImage);

            if(imageIO.getHeight() >= imageIO.getWidth()) {
                imageIO.setWidth(imageIO.getWidth() + resizeValue);
            } else {
                imageIO.setHeight(imageIO.getHeight() + resizeValue);
            }

            int indentH = (this.getHeight() - imageIO.getHeight()) / 2;
            int indentW = (this.getWidth() - imageIO.getWidth()) / 2;

            BufferedImage resizedImage = new BufferedImage(imageIO.getWidth(), imageIO.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(imageIO.getImage(), indentW, indentH, imageIO.getWidth(), imageIO.getHeight(), null);
            g.dispose();

            image = resizedImage;
        }
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
        
    }
    
    /**
     * Resize cropping area.
     * 
     * @param newValue 
     */
    public void resizeCropSelection(int newValue) {
        // Update crop area values.
        srcx = mainsrcx + (100 - newValue);
        srcy = mainsrcy + (100 - newValue);
        destx = maindestx - (100 - newValue);
        desty = maindesty - (100 - newValue);
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
    }
    
}
