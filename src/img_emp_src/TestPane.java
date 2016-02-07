/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import img_emp_src.TestAnimatedPane.Animate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author egrubellano
 */
public class TestPane extends JLayeredPane {

    private static final int WIDE = 200;
    private static final int HIGH = 5 * WIDE / 8; // ~1/phi
    private JPanel panel;

    public TestPane() {
        panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.add(new JButton("Test"));
        add(panel);

        Dimension size = panel.getPreferredSize();
        int half = HIGH / 2 - size.height / 2;
        Rectangle from = new Rectangle(size);
        from.translate(WIDE, half);
        Rectangle to = new Rectangle(size);
        to.translate(0, half);
        panel.setBounds(from);

        Animate animate = new Animate(panel, from, to);
        animate.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDE, HIGH);
    }
}
