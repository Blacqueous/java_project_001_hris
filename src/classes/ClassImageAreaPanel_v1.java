/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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
public class ClassImageAreaPanel_v1 extends JPanel {
    
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
    private int imageH = 0;
    private int imageW = 0;
    
    String img_path = getClass().getResource("/img_emp_src/").getFile();
    
    /**
     * Construct an ImageArea component.
     */
    public ClassImageAreaPanel_v1() {
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
     * @return JPanel ClassImageAreaPanelv2
     */
    public static ClassImageAreaPanel_v1 create(){
        
        // Create panel.
        ClassImageAreaPanel_v1 panel = new ClassImageAreaPanel_v1();
        
        // Repaint the panel with the listeners.
        panel.repaint();
        
        // Return customized panel.
        return panel;
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
     * @param source original source image
     */
    public void setImage(Image img, Image source) {
        // Save the image for later repaint.
        image = img;
        imagesource = source;
        imageH = image.getHeight(this);
        imageW = image.getWidth(this);
        
        int indentH = (this.getHeight() - image.getHeight(this)) / 2;
        int indentW = (this.getWidth() - image.getWidth(this)) / 2;
        
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
     * Update size of selected image and update the display.
     * 
     * @param resizeValue integer value of resize/zoom
     * @param quality boolean indicator
     */
    public void resizeImage(int resizeValue, boolean quality) {
        // Check if an image exists before resizing.
        if(image == null) { return; }
        
        // Update global zoom value.
        zoomvalue = resizeValue;
        
        // Scale in respect to width or height?
        Scalr.Mode scaleMode;

        // Find out which side is the shortest.
        int maxSize = 0;
        
        // Check what scaling to use.
        if (imagesource.getHeight(this) > imagesource.getWidth(this)) {
            // Scale to width.
            scaleMode = Scalr.Mode.FIT_TO_WIDTH;
            maxSize = imageW + resizeValue;
        } else {
            // Scale to height.
            scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
            maxSize = imageH + resizeValue;
        }
        
        BufferedImage outputImage;
        if(quality) {
            outputImage = Scalr.resize((BufferedImage)imagesource, Scalr.Method.QUALITY, scaleMode, maxSize);
        } else {
            outputImage = Scalr.resize((BufferedImage)imagesource, Scalr.Method.SPEED, scaleMode, maxSize);
        }
        
        int indentH = (this.getHeight() - outputImage.getHeight()) / 2;
        int indentW = (this.getWidth() - outputImage.getWidth()) / 2;
        
        BufferedImage resizedImage = new BufferedImage(outputImage.getWidth(), outputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(outputImage, indentW, indentH, outputImage.getWidth(), outputImage.getHeight(), null);
        g.dispose();
        
        // Update image variable to update panel's image display.
        image = resizedImage;

        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
        
    }
    
    /**
     * Crop the image to the dimensions of the selection rectangle.
     *
     * @return true if cropping succeeds.
     */
    public boolean cropImage() {
        // There is nothing to crop if the selection rectangle is only a single
        // point.
        if (srcx == destx && srcy == desty) { return true; }
        
        // Assume success.
        boolean succeeded = true;
        
        // Compute upper-left and lower-right coordinates for selection
        // rectangle corners.
        int x1 = (srcx < destx) ? srcx : destx;
        int y1 = (srcy < desty) ? srcy : desty;
        
        int x2 = (srcx > destx) ? srcx : destx;
        int y2 = (srcy > desty) ? srcy : desty;
        
        // Compute width and height of selection rectangle.
        int width = (x2 - x1);
        int height = (y2 - y1);
        
        // Reset global image to original image.
        image = imagesource;
        
        // Scale in respect to width or height?
        Scalr.Mode scaleMode;
        
        // find out which side is the shortest.
        int maxSize = 0;
        
        // Check what scaling to use.
        if (imagesource.getHeight(this) > imagesource.getWidth(this)) {
            // Scale to width.
            scaleMode = Scalr.Mode.FIT_TO_WIDTH;
            maxSize = this.getWidth() + zoomvalue;
        } else {
            // Scale to height.
            scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
            maxSize = this.getHeight() + zoomvalue;
        }
        
        BufferedImage outputImage = Scalr.resize((BufferedImage)imagesource, Scalr.Method.ULTRA_QUALITY, scaleMode, maxSize);
        Graphics2D g = outputImage.createGraphics();
        
         int indentH = (this.getHeight() - outputImage.getHeight()) / 2;
         int indentW = (this.getWidth() - outputImage.getWidth()) / 2;
        
        g.drawImage(outputImage, indentW, indentH, outputImage.getWidth(), outputImage.getHeight(), null);
        g.dispose();
        
        image = outputImage;
        
        // Create a buffer to hold cropped image.
        BufferedImage biCrop = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = biCrop.createGraphics();
        // g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.drawRoundRect(x1, y1, width, height, 0, 0);
        
        // Perform the crop operation.
        try {
            BufferedImage bi = (BufferedImage) image;
            BufferedImage bi2 = bi.getSubimage(x1, y1, width, height);
            g2d.drawImage(bi2, null, 0, 0);
        } catch (RasterFormatException ex) {
            // Cropping failed.
            succeeded = false;
        }
        
        g2d.dispose();
        
        if (succeeded) {
            // Set path of image to be saved.
            File img_path_file = new File(img_path);
            // Try saving the uploaded image.
            try {
                javaxt.io.Image images = new javaxt.io.Image(biCrop);
                images.resize(width, height);
                
                ImageIO.write(images.getBufferedImage(), imageextension, new File(img_path_file.getAbsolutePath() + "\\1." + imageextension));
                
                croppedimage = images.getBufferedImage();
            } catch (IOException ex) {
                // Cropping failed.
                succeeded = false;
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
        
        // Return bollean.
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
     * Return the cropped image.
     *
     * @return Image reference to current image
     */
    public Image getCroppedImage() {
        return croppedimage;
    }
    
}
