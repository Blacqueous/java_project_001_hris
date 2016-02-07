/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author egrubellano
 */
public class ClassIconCustomizer {
    
    int alphaValue;
    
    public static BufferedImage convertToBufferedImage(ImageIcon imgIcon) {
        
        Image img = imgIcon.getImage();
        BufferedImage newImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        return newImage;
        
    }
    
    public void changeColor(BufferedImage img, Color newColor, JLabel lbl) {
        
        // Set New Color
        // TODO: To be improve. Much more improve :|
        final int newRGB = newColor.getRGB();
        
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y), true);
                Color newC = new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
                // System.out.println("(" + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + ", " + c.getAlpha() + ")");
                if(c.getRed() > 50){
                    newC = new Color(c.getRed()-25, c.getGreen()+15, c.getBlue()+15, c.getAlpha());
                }
                // if (img.getRGB(x, y) == 224551522)
                img.setRGB(x, y, newC.getRGB());
            }
        }
        
        lbl.setIcon(new ImageIcon(img));
        
    }
    
    public void frameOptionChangeIcon(Color newColor, ArrayList<JLabel> arrayList){
        
//        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/img_src/icon_16_lock.png"));
        for ( int i=0; i<arrayList.size(); i++) {
            ImageIcon icon = (ImageIcon) arrayList.get(i).getIcon();
            BufferedImage bufferedImage = convertToBufferedImage(icon);
        
            changeColor(bufferedImage, newColor, arrayList.get(i));
        }
        
    }
    
    public void changeAlpha(ArrayList<JLabel> arrayList, int alphaSet) {
        this.alphaValue = alphaSet;
        for ( int i=0; i<arrayList.size(); i++) {
            ImageIcon icon = (ImageIcon) arrayList.get(i).getIcon(); 
            BufferedImage img = convertToBufferedImage(icon);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color c = new Color(img.getRGB(x, y), true);
                    int alpha = c.getAlpha();
                    if(alpha > alphaSet)
                        alpha -= this.alphaValue;
                    c = new Color(c.getRed(), 50, 50, alpha);
                    img.setRGB(x, y, c.getRGB());
                }
            }
            arrayList.get(i).setIcon(new ImageIcon(img));
        }
        
    }
    
    public void changeAlphaFull(JLabel lbl) {
        
        ImageIcon icon = (ImageIcon) lbl.getIcon(); 
        BufferedImage img = convertToBufferedImage(icon);
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y), true);
                int alpha = c.getAlpha();
                if(alpha > this.alphaValue)
                    alpha += this.alphaValue;
                c = new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
                img.setRGB(x, y, c.getRGB());
            }
        }
        lbl.setIcon(new ImageIcon(img));
        
    }
    
    public void changeAlphaHalf(JLabel lbl) {
        
        ImageIcon icon = (ImageIcon) lbl.getIcon(); 
        BufferedImage img = convertToBufferedImage(icon);
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y), true);
                int alpha = c.getAlpha();
                if(alpha > this.alphaValue)
                    alpha -= this.alphaValue;
                c = new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
                img.setRGB(x, y, c.getRGB());
            }
        }
        lbl.setIcon(new ImageIcon(img));
        
    }
    
}
