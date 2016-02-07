/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Web Dev
 */
public class ClassButtonShape extends JButton {

    protected final Color fc = new Color(100, 150, 255, 200);
    protected final Color ac = new Color(230, 230, 230);
    protected final Color rc = Color.ORANGE;
    protected final Shape shape;

    public ClassButtonShape(Shape s) {
        super();
        shape = s;
        setModel(new DefaultButtonModel());
        init("Shape", new DummySizeIcon(s));
        setVerticalAlignment(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBackground(new Color(250, 250, 250));
    }

    private void paintFocusAndRollover(Graphics2D g2, Color color) {
        g2.setPaint(new GradientPaint(0, 0, color, getWidth() - 1, getHeight() - 1, color.brighter(), true));
        g2.fill(shape);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) {
            g2.setColor(ac);
            g2.fill(shape);
        } else if (isRolloverEnabled() && getModel().isRollover()) {
            paintFocusAndRollover(g2, rc);
        } else if (hasFocus()) {
            paintFocusAndRollover(g2, fc);
        } else {
            g2.setColor(getBackground());
            g2.fill(shape);
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2.setColor(getBackground());
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(shape);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        return shape.contains(x, y);
    }
    /*/ Test
     @Override public Dimension getPreferredSize() {
     Rectangle r = shape.getBounds();
     return new Dimension(r.width, r.height);
     }
     /*/

    private static class DummySizeIcon implements Icon {

        private final Shape shape;

        public DummySizeIcon(Shape s) {
            shape = s;
        }

        @Override
        public int getIconWidth() {
            return shape.getBounds().width;
        }

        @Override
        public int getIconHeight() {
            return shape.getBounds().height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) { /* Empty icon */ }
    }

    public Path2D.Double makeStar(int r1, int r2, int vc) {
        
        int or = Math.max(r1, r2);
        int ir = Math.min(r1, r2);
        double agl = 0d;
        double add = 2 * Math.PI / (vc * 2);
        Path2D.Double p = new Path2D.Double();
        p.moveTo(or * 1, or * 0);
        for (int i = 0; i < vc * 2 - 1; i++) {
            agl += add;
            int r = i % 2 == 0 ? ir : or;
            p.lineTo(r * Math.cos(agl), r * Math.sin(agl));
        }
        p.closePath();
        AffineTransform at = AffineTransform.getRotateInstance(-Math.PI / 2, or, 0);
        return new Path2D.Double(p, at);
        
    }
    
}
