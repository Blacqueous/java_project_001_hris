/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author egrubellano
 */
public class ClassLabelButton {

    /**
     * Set a JLabel label design as a button.
     * 
     * @param lbl
     * @param bgp
     * @param bgn
     * @param bgo
     * @param fgn
     * @param fgo 
     */
    public void addClass(final JLabel lbl, final Color bgp, final Color bgn, final Color bgo, final Color fgn, final Color fgo) { 
        
        lbl.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                lbl.setBackground(bgn);
                lbl.setForeground(fgn);
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                lbl.setBackground(bgn.darker());
//                lbl.setForeground(fgn.darker());
                lbl.setBackground(bgp);
                lbl.setForeground(fgn);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbl.setBackground(bgo);
                lbl.setForeground(fgo);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbl.setBackground(bgn);
                lbl.setForeground(fgn);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl.setBackground(bgo);
                lbl.setForeground(fgo);
            }
        });
    }

    /**
     * Set a JMenuItem design as a button.
     * 
     * @param item
     * @param bgp
     * @param bgn
     * @param bgo
     * @param fgn
     * @param fgo 
     */
    public void addClass(final JMenuItem item, final Color bgp, final Color bgn, final Color bgo, final Color fgn, final Color fgo) { 
        
        item.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                item.setBackground(bgn);
                item.setForeground(fgn);
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                lbl.setBackground(bgn.darker());
//                lbl.setForeground(fgn.darker());
                item.setBackground(bgp);
                item.setForeground(fgn);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                item.setBackground(bgo);
                item.setForeground(fgo);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(bgn);
                item.setForeground(fgn);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(bgo);
                item.setForeground(fgo);
            }
        });
    }
}
