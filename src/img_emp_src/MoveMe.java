/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

///**
// *
// * @author egrubellano
// */
//public class MoveMe {
//
//    public static void main(String[] args) {
//        MoveMe moveMe = new MoveMe();
//    }
//    
//    public MoveMe() {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    
//                }
//
//                JFrame frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setLayout(new BorderLayout());
//                frame.add(new MoveMePane());
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//    }
//
//    public class MoveMePane extends JLayeredPane {
//
//        public MoveMePane() {
//            int width = 400;
//            int height = 400;
//            for (int index = 0; index < 10; index++) {
//                String text = "Label " + index;
//                JPanel panel = new JPanel();
//                panel.setBackground(new Color(255, 255, index*10));
//                panel.setSize(new Dimension(200, 150));
//                
//                int a = (int) Math.round(Math.random() * width);
//                int b = (int) Math.round(Math.random() * height);
//                if (a + panel.getWidth() > width) {
//                    a = width - panel.getWidth();
//                }
//                if (b + panel.getHeight() > width) {
//                    b = width - panel.getHeight();
//                }
//                panel.setLocation(a, b);
//                panel.repaint();
//                add(panel);
//                
////                JLabel label = new JLabel(text);
////                label.setSize(label.getPreferredSize());
////
////                int x = (int) Math.round(Math.random() * width);
////                int y = (int) Math.round(Math.random() * height);
////                if (x + label.getWidth() > width) {
////                    x = width - label.getWidth();
////                }
////                if (y + label.getHeight() > width) {
////                    y = width - label.getHeight();
////                }
////                label.setLocation(x, y);
////                label.repaint();
////                add(label);
//            }
//            
//            MoveMeMouseHandler handler = new MoveMeMouseHandler();
//            addMouseListener(handler);
//            addMouseMotionListener(handler);
//        }
//
//        @Override
//        public Dimension getPreferredSize() {
//            return new Dimension(400, 400);
//        }
//    }
//
//    public class MoveMeMouseHandler extends MouseAdapter {
//
//        private int xOffset;
//        private int yOffset;
//        private JPanel draggy;
//        private String oldText;
//        private Color oldColor;
//
//        @Override
//        public void mouseReleased(MouseEvent me) {
//            if (draggy != null) {
////                draggy.setText(oldText);
//                draggy.setBackground(oldColor);
////                draggy.setSize(draggy.getPreferredSize());
//                draggy = null;
//            }
//        }
//
//        @Override
//        public void mousePressed(MouseEvent me) {
//            JComponent comp = (JComponent) me.getComponent();
//            Component child = comp.findComponentAt(me.getPoint());
//            if (child instanceof JPanel) {
//                xOffset = me.getX() - child.getX();
//                yOffset = me.getY() - child.getY();
//
//                draggy = (JPanel) child;
////                oldText = draggy.getText();
//                oldColor = draggy.getBackground();
////                draggy.setText("What a drag");
//                draggy.setBackground(Color.black);
////                draggy.setSize(draggy.getPreferredSize());
//            }
//        }
//
//        @Override
//        public void mouseDragged(MouseEvent me) {
//            if (draggy != null) {
//                draggy.setLocation(me.getX() - xOffset, me.getY() - yOffset);
//            }
//        }
//    }
//}
public class MoveMe {

    public static void main(String[] args) {
        new MoveMe();
    }

    public MoveMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MoveMePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MoveMePane extends JLayeredPane {

        public MoveMePane() {
            int width = 400;
            int height = 400;
            for (int index = 0; index < 10; index++) {
                String text = "Label " + index;
                JLabel label = new JLabel(text);
                label.setSize(label.getPreferredSize());

                int x = (int) Math.round(Math.random() * width);
                int y = (int) Math.round(Math.random() * height);
                if (x + label.getWidth() > width) {
                    x = width - label.getWidth();
                }
                if (y + label.getHeight() > width) {
                    y = width - label.getHeight();
                }
                label.setLocation(x, y);
                add(label);
            }

            MoveMeMouseHandler handler = new MoveMeMouseHandler();
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public class MoveMeMouseHandler extends MouseAdapter {

        private int xOffset;
        private int yOffset;
        private JLabel draggy;
        private String oldText;

        @Override
        public void mouseReleased(MouseEvent me) {
            if (draggy != null) {
                draggy.setText(oldText);
                draggy.setSize(draggy.getPreferredSize());
                draggy = null;
            }
        }

        public void mousePressed(MouseEvent me) {
            JComponent comp = (JComponent) me.getComponent();
            Component child = comp.findComponentAt(me.getPoint());
            if (child instanceof JLabel) {
                xOffset = me.getX() - child.getX();
                yOffset = me.getY() - child.getY();

                draggy = (JLabel) child;
                oldText = draggy.getText();
                draggy.setText("What a drag");
                draggy.setSize(draggy.getPreferredSize());
            }
        }

        public void mouseDragged(MouseEvent me) {
            if (draggy != null) {
                draggy.setLocation(me.getX() - xOffset, me.getY() - yOffset);
            }
        }
    }
}