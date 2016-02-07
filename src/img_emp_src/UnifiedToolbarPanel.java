/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author egrubellano
 */
public class UnifiedToolbarPanel extends JPanel implements WindowFocusListener {

    public static final Color OS_X_UNIFIED_TOOLBAR_FOCUSED_BOTTOM_COLOR =
            new Color(64, 64, 64);
    public static final Color OS_X_UNIFIED_TOOLBAR_UNFOCUSED_BORDER_COLOR =
            new Color(135, 135, 135);    

    public static final Color OS_X_TOP_FOCUSED_GRADIENT = new Color(214+8, 214+8, 214+8);
    public static final Color OS_X_BOTTOM_FOCUSED_GRADIENT = new Color(217, 217, 217);
    public static final Color OS_X_TOP_UNFOCUSED_GRADIENT = new Color(240+3, 240+3, 240+3);
    public static final Color OS_X_BOTTOM_UNFOCUSED_GRADIENT = new Color(219, 219, 219);

    public UnifiedToolbarPanel() {
        // make the component transparent
        setOpaque(true);
        Window window = SwingUtilities.getWindowAncestor(this);
        // create an empty border around the panel
        // note the border below is created using JGoodies Forms
//        setBorder(Borders.createEmptyBorder("3dlu, 3dlu, 1dlu, 3dlu"));
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Window window = SwingUtilities.getWindowAncestor(this);
        Color color1  = window.isFocused() ? OS_X_TOP_FOCUSED_GRADIENT
                : OS_X_TOP_UNFOCUSED_GRADIENT;
        Color color2 = window.isFocused() ? color1.darker()
                : OS_X_BOTTOM_UNFOCUSED_GRADIENT;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(
            0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    @Override
    public Border getBorder() {
        Window window = SwingUtilities.getWindowAncestor(this);
        return window != null && window.isFocused()
                ? BorderFactory.createMatteBorder(0,0,1,0,
                        OS_X_UNIFIED_TOOLBAR_FOCUSED_BOTTOM_COLOR)
                : BorderFactory.createMatteBorder(0,0,1,0,
                       OS_X_UNIFIED_TOOLBAR_UNFOCUSED_BORDER_COLOR);
    }


    @Override
    public void windowGainedFocus(WindowEvent e) {
        repaint();
    }


    @Override
    public void windowLostFocus(WindowEvent e) {
        repaint();
    }
}
