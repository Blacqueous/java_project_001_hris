/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author egrubellano
 */
public final class ClassTextfieldMasker {

    AbstractFormatterFactory aff, dff;
    MaskFormatter mf;

    public ClassTextfieldMasker(final JFormattedTextField ftf, final String sm) {

        ApplyTextFieldMask(ftf, sm);
    }

    public void ApplyTextFieldMask(final JFormattedTextField ftf, final String sm) {

        try {
            mf = new javax.swing.text.MaskFormatter(sm);
        } catch (ParseException ex) {
            mf = null;
            // Logger.getLogger(null).log(Level.SEVERE, null, ex);
        }

        aff = new javax.swing.text.DefaultFormatterFactory(mf);

        ftf.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    ftf.commitEdit();
                } catch (ParseException ex) {
                    // Logger.getLogger(ClassTextfieldMasker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ftf.addFocusListener(new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftf.setFormatterFactory(aff);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if ( ftf.isEditValid() ) {
                    if ( mf.getMask().length() != ftf.getText().trim().length() ) {
                        ClearTextFieldMask(ftf);
                    }
                } else {
                    ClearTextFieldMask(ftf);
                }
            }

        });

    }

    public void ClearTextFieldMask(final JFormattedTextField ftf) {

        ftf.setFormatterFactory(dff);
        ftf.setValue(null);
        ftf.setText("");

    }

}
