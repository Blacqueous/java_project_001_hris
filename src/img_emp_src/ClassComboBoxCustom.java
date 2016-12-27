/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_emp_src;

import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.synth.SynthComboBoxUI;

/**
 *
 * @author egrubellano
 */
public class ClassComboBoxCustom extends JComboBox {

    public ClassComboBoxCustom() {
        setUI(new ClassCustomComboBoxUI());
    }
    
}

 class ClassCustomComboBoxUI extends SynthComboBoxUI {

    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup basicpopup = new BasicComboPopup(comboBox) {
            @Override
            protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
                return super.computePopupBounds(
                        px, py, Math.max(comboBox.getPreferredSize().width, pw), ph
                ); 
           }
        };
        basicpopup.getAccessibleContext().setAccessibleParent(comboBox);
        return basicpopup;
    }
}
