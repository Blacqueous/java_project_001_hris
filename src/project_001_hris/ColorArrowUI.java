/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Web Dev
 */
public class ColorArrowUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new ColorArrowUI();
    }

    @Override
    protected JButton createArrowButton() {
        super.createArrowButton().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_src/icon_16_black_calendar.png")));
        return super.createArrowButton(); //To change body of generated methods, choose Tools | Templates.
    }

    

}
