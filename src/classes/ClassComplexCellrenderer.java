/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author egrubellano
 */
public class ClassComplexCellrenderer implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    public String title;

    /**
     * Is this list cell editor for a jDialog?
     * Default value is false.
     */
    public boolean isForDialog = false;

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if(value.toString().trim().equals("")) {
            renderer.setText(title);
            renderer.setForeground(new Color(0, 0, 0, 0.2f));
            if(!isForDialog){
                renderer.setBorder(new EmptyBorder(5, 5, 5, 15));
            } else {
                renderer.setBorder(new EmptyBorder(5, 15, 5, 15));
            }
            renderer.setFont(new Font("Arial", Font.ITALIC, 11));
        } else {
            renderer.setText(value.toString());
            renderer.setForeground(new Color(0, 0, 0));
            if(!isForDialog){
                renderer.setBorder(new EmptyBorder(2, 5, 2, 15));
            } else {
                renderer.setBorder(new EmptyBorder(2, 15, 2, 15));
            }
            renderer.setFont(new Font("Arial", Font.PLAIN, 11));
        }


        return renderer;

    }

}
