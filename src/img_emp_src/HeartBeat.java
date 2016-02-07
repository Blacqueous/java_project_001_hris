/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author egrubellano
 */
public class HeartBeat extends JPanel {

    public static void main(String[] args) throws Exception {
        new HeartBeat();
    }

    public HeartBeat() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel j = new JPanel();
                j.add(new HeartBeat2());
                frame.add(j);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    class HeartBeat2 extends JPanel {

        BufferedImage bi;

//        public HeartBeat2(){
//        try {
//            bi = ImageIO.read(new URL("http://i.stack.imgur.com/i8UJD.jpg"));
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                final BufferedImage canvas = new BufferedImage(
//                        bi.getWidth(), bi.getHeight(),
//                        BufferedImage.TYPE_INT_RGB);
//                final JLabel animationLabel = new JLabel(new ImageIcon(canvas));
//                ActionListener animator = new ActionListener() {
//
//                    int x = 0;
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        Graphics2D g = canvas.createGraphics();
//
//                        // paint last part of image in left of canvas
//                        g.drawImage(bi, x, 0, null);
//                        // paint first part of image immediately to the right
//                        g.drawImage(bi, x + bi.getWidth(), 0, null);
//
//                        // reset x to prevent hitting integer overflow
//                        if (x%bi.getWidth()==0) x = 0;
//
//                        g.dispose();
//                        animationLabel.repaint();
//                        x--;
//                    }
//                };
//                Timer timer = new Timer(40, animator);
//                timer.start();
//                JPanel j = new JPanel();
//                JOptionPane.showMessageDialog(null, animationLabel);
//                timer.stop();
//            }
//        };
//        // Swing GUIs should be created and updated on the EDT
//        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
//        SwingUtilities.invokeLater(r);
//    }
        public HeartBeat2() {

            try {
                bi = ImageIO.read(new URL("http://i.stack.imgur.com/i8UJD.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            final BufferedImage canvas = new BufferedImage(
                    bi.getWidth(), bi.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            final JLabel animationLabel = new JLabel(new ImageIcon(canvas));
            add(animationLabel);

            ActionListener animator = new ActionListener() {

                int x = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    Graphics2D g = canvas.createGraphics();

                    // paint last part of image in left of canvas
                    g.drawImage(bi, x, 0, null);
                    // paint first part of image immediately to the right
                    g.drawImage(bi, x + bi.getWidth(), 0, null);

                    // reset x to prevent hitting integer overflow
                    if (x % bi.getWidth() == 0) {
                        x = 0;
                    }

                    g.dispose();
                    animationLabel.repaint();
                    x--;
                }
            };

            Timer timer = new Timer(40, animator);
            timer.start();
        }
    }
}
