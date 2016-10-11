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
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
    private static Image image_source;
    
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
//        panel.addMouseListener(ml);

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
//        panel.addMouseMotionListener(mml);
        
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
//        panel.addComponentListener(resizeListener);
        
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
        if (srcx == destx && srcy == desty) {
            return true;
        }
        
        // Assume success.
        boolean succeeded = true;
        
        // Compute upper-left and lower-right coordinates for selection
        // rectangle corners.
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
        
        // Change to image to circle.
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.clip(new Ellipse2D.Float(0, 0, width, height));
            Area outside = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
                 outside.subtract(new Area(g2d.getClipBounds()));
                g2d.clip(outside);
        g2d.setColor(new Color(255, 255, 255, 0));
        g2d.fillRect(x1, y1, width, height);
        
        // Perform the crop operation.
        try {
System.out.println(x1);
System.out.println(y1);
System.out.println(width);
System.out.println(height);
            BufferedImage bi = (BufferedImage)this.image;
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
                
                ImageIO.write(images.getBufferedImage(), "png", new File(img_path_file.getAbsolutePath() + "\\1.png"));
                
                croppedimage = images.getBufferedImage();
                
            } catch (IOException ex) {
                // handle exception...
            }
            
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
            rectSelection.x = x1;
            rectSelection.y = y1;
            
            // Establish selection rectangle extents.
            rectSelection.width = (x2 - x1);
            rectSelection.height = (y2 - y1);
            
            // Draw selection rectangle.
            Graphics2D g2d = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(x1, y1, ((x2-x1)+1), ((y2-y1)+1));
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            
            Area outter = new Area(new Rectangle(0, 0, this.getWidth(), this.getHeight()));
            
            outter.subtract(new Area(circle));
            g2d.setColor(new Color(255, 255, 255));
            g2d.fill(outter);
            
            g2d.setStroke(bs);
            g2d.setPaint(gp);
            
            g2d.drawOval(x1, y1, ((x2-x1)+1), ((y2-y1)+1));
            
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
        this.image_source = image;
        
        int indentH = (this.getHeight()-image.getHeight(this)) / 2;
        int indentW = (this.getWidth()-image.getWidth(this)) / 2;
        
        BufferedImage resizedImage = new BufferedImage(image.getWidth(this), image.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, indentW, indentH, image.getWidth(this), image.getHeight(this), null);
        g.dispose();
        
//        javaxt.io.Image imageIO = new javaxt.io.Image((BufferedImage)image);
//        
//        if(imageIO.getHeight() >= imageIO.getWidth()) {
//            imageIO.setWidth(imageIO.getWidth() - 500);
//        } else {
//            imageIO.setHeight(imageIO.getHeight() - 500);
//        }
//        
//        int indentH = (this.getHeight() - imageIO.getHeight()) / 2;
//        int indentW = (this.getWidth() - imageIO.getWidth()) / 2;
//        
//        BufferedImage resizedImage = new BufferedImage(imageIO.getWidth(), imageIO.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = resizedImage.createGraphics();
//        g.drawImage(imageIO.getImage(), indentW, indentH, imageIO.getWidth(), imageIO.getHeight(), null);
//        g.dispose();
        
//        this.image = resizedImage;
        
        this.image = resizedImage;
        
        // Set image crop size
        if(this.getHeight() >= this.getWidth()) {
            mainsrcx = srcx = 0;
            mainsrcy = srcy = (this.getHeight() / 2) - (this.getWidth() / 2);
            maindestx = destx = this.getWidth();
            maindesty = desty = this.getWidth() + mainsrcy;
        } else {
            mainsrcx = srcx = (this.getWidth() / 2) - (this.getHeight() / 2);
            mainsrcy = srcy = 0;
            maindestx = destx = this.getHeight() + mainsrcx;
            maindesty = desty = this.getHeight();
        }
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
        
    }
    
    public void resizeImage(int resizeValue) {
        
        if(this.image_source == null) { return; }
        
        // Check if resize value is not negative.
        if(resizeValue <= 0) {
            resizeValue = 0;
        }
        
        // Save the image for later repaint.
        Image sourceImage = this.image_source;
        
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
        
        this.image = resizedImage;
        
        // Present scrollbars as necessary.
        revalidate();
        
        // Update the image displayed on the panel.
        repaint();
        
    }
    
    public void resizeCropSelection(int newValue) {
        
        srcx = mainsrcx + (100-newValue);
        srcy = mainsrcy + (100-newValue);
        destx = maindestx - (100-newValue);
        desty = maindesty - (100-newValue);
        repaint();
        
    }
    
}
