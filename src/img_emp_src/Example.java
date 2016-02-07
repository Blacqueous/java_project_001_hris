/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author egrubellano
 */
public class Example extends JPanel {
    ArrayList<ExampleComponent> components;

    public Example() {
        components = new ArrayList<>();
    }


    public void addComponent(ExampleComponent j) {
        components.add(j);
        add(j);
    }

    public static void main(String[] args) {
        JFrame app = new JFrame("Staff Prototype");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Example s = new Example();
        s.setLayout(null);
        app.getContentPane().add(s);
        s.addComponent(s.new ExampleComponent(new Rectangle(0,0,25,25)));
        s.addComponent(s.new ExampleComponent(new Rectangle(45,45,25,25)));
        app.pack();
        app.setVisible(true);
    }

    class ExampleComponent extends JPanel implements MouseMotionListener {

        public ExampleComponent(Rectangle bounds) {
            URL resource = getClass().getResource("Galaxy2.jpg");
            ImageIcon icon = new ImageIcon(resource);
            add(new JLabel(icon));
            addMouseMotionListener(this);
            setBounds(bounds);
        }

        @Override
        public void mouseMoved(MouseEvent m) {
            System.out.println("Mouse Moved");
        }

        @Override
        public void mouseDragged(MouseEvent m) {
            System.out.println("Mouse Dragged");
        }
    }
}