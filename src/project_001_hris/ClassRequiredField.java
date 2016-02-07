/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import santhosh.WideComboBox;

/**
 *
 * @author egrubellano
 */
public class ClassRequiredField {

    ClassFormatDateValue fDateValue = new ClassFormatDateValue();

    public void requiredFieldsInitialize(final ArrayList<Component> arrayList) {
        
        for (int i = 0; i < arrayList.size(); i++) {
            final int count = i;
            if(arrayList.get(i).getClass().equals(new JTextField().getClass())) { // If component is a JTextField
                arrayList.get(i).addFocusListener(new java.awt.event.FocusAdapter() {
                    @Override
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        if(!arrayList.get(count).getBackground().equals(Color.WHITE)) {
                            arrayList.get(count).setBackground(Color.WHITE);
                        }
                    }
                    @Override
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        // Not supported yet.
                    }
                });
            } else if(arrayList.get(i).getClass().equals(new JDateChooser().getClass())) { // If component is a JDateChooser
                final JDateChooser dateField = (JDateChooser) arrayList.get(i);
                dateField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if(!dateField.getComponent(0).getBackground().equals(new Color(180, 180, 180)) && !dateField.getComponent(1).getBackground().equals(Color.WHITE)) {
                            dateField.getComponent(0).setBackground(new Color(180, 180, 180));
                            dateField.getComponent(1).setBackground(Color.WHITE);
                        }
                    }
                    
                });
            } else if(arrayList.get(i).getClass().equals(new WideComboBox().getClass()) ||
                      arrayList.get(i).getClass().equals(new JComboBox().getClass())) { // If component is a JComboBox & WideComboBox
                arrayList.get(i).addFocusListener(new java.awt.event.FocusAdapter() {
                    @Override
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        if(!arrayList.get(count).getBackground().equals(new Color(150, 150, 150))) {
                            arrayList.get(count).setBackground(new Color(150, 150, 150));
                        }
                    }
                    @Override
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        // Not supported yet.
                    }
                });
            } else if(arrayList.get(i).getClass().equals(new JFormattedTextField().getClass())) { // If component is a JFormattedTextField
                arrayList.get(i).addFocusListener(new java.awt.event.FocusAdapter() {
                    @Override
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        if(!arrayList.get(count).getBackground().equals(Color.WHITE)) {
                            arrayList.get(count).setBackground(Color.WHITE);
                        }
                    }
                    @Override
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        // Not supported yet.
                    }
                });
            }
        }
        
    }

    public boolean requiredFieldsValidate(final ArrayList<Component> arrayList) {
        
        boolean areValid = true;
        boolean putFocus = false;
        
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getClass().equals(new JTextField().getClass()) && ((JTextField) arrayList.get(i)).getText().trim().isEmpty()) { // If component is a JTextField
                areValid = false;
                arrayList.get(i).setBackground(new Color(255, 100, 100));
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                }
            } else if(arrayList.get(i).getClass().equals(new JDateChooser().getClass()) && fDateValue.formatDateToString((JDateChooser) arrayList.get(i)).trim().isEmpty()) { // If component is a JDateChooser
                areValid = false;
                JDateChooser dateField = (JDateChooser) arrayList.get(i);
                dateField.getComponent(0).setBackground(new Color(255, 150, 150));
                dateField.getComponent(1).setBackground(new Color(255, 150, 150));
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    dateField.getComponent(1).requestFocus();
                }
            } else if((arrayList.get(i).getClass().equals(new WideComboBox().getClass()) && ((WideComboBox) arrayList.get(i)).getSelectedIndex() == 0) ||
                      (arrayList.get(i).getClass().equals(new JComboBox().getClass()) && ((JComboBox) arrayList.get(i)).getSelectedIndex() == 0)) { // If component is a JComboBox & WideComboBox
                areValid = false;
                arrayList.get(i).setBackground(new Color(255, 35, 35));
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                }
            } else if(arrayList.get(i).getClass().equals(new JFormattedTextField().getClass()) && ((JFormattedTextField) arrayList.get(i)).getValue() == null) { // If component is a JFormattedTextField
                areValid = false;
                arrayList.get(i).setBackground(new Color(255, 100, 100));
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                }
            }
        }
        
        return areValid;
        
    }

    public void requiredFieldsClear(final ArrayList<Component> arrayList) {
        
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getClass().equals(new JTextField().getClass())) { // If component is a JTextField
                ((JTextField) arrayList.get(i)).setText("`");
                ((JTextField) arrayList.get(i)).setText("");
                arrayList.get(i).setBackground(Color.WHITE);
            } else if(arrayList.get(i).getClass().equals(new JDateChooser().getClass())) { // If component is a JDateChooser
                ((JDateChooser) arrayList.get(i)).setDate(null);
                final JDateChooser dateField = (JDateChooser) arrayList.get(i);
                dateField.getComponent(0).setBackground(new Color(180, 180, 180));
                dateField.getComponent(1).setBackground(Color.WHITE);
            } else if(arrayList.get(i).getClass().equals(new WideComboBox().getClass()) ||
                      arrayList.get(i).getClass().equals(new JComboBox().getClass())) { // If component is a JComboBox & WideComboBox
                ((JComboBox) arrayList.get(i)).setSelectedIndex(0);
                arrayList.get(i).setBackground(new Color(150, 150, 150));
            } else if(arrayList.get(i).getClass().equals(new JFormattedTextField().getClass())) { // If component is a JFormattedTextField
                ((JFormattedTextField) arrayList.get(i)).setValue(null);
                arrayList.get(i).setBackground(Color.WHITE);
            }
        }
        
    }
    
    public void requiredScrollTo(final ArrayList<Component> arrayList, JScrollPane panelScroll) {

        boolean putFocus = false;
        
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getClass().equals(new JTextField().getClass()) && ((JTextField) arrayList.get(i)).getText().trim().isEmpty()) { // If component is a JTextField
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                    if(i <= 8) {
                        panelScroll.getViewport().setViewPosition(new Point(0,0));
                    } else {
                        panelScroll.getViewport().setViewPosition(new Point(0,345));
                    }
                }
            } else if(arrayList.get(i).getClass().equals(new JDateChooser().getClass()) && fDateValue.formatDateToString((JDateChooser) arrayList.get(i)).trim().isEmpty()) { // If component is a JDateChooser
                JDateChooser dateField = (JDateChooser) arrayList.get(i);
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    dateField.getComponent(1).requestFocus();
                    if(i <= 8) {
                        panelScroll.getViewport().setViewPosition(new Point(0,0));
                    } else {
                        panelScroll.getViewport().setViewPosition(new Point(0,345));
                    }
                }
            } else if((arrayList.get(i).getClass().equals(new WideComboBox().getClass()) && ((WideComboBox) arrayList.get(i)).getSelectedIndex() == 0) ||
                      (arrayList.get(i).getClass().equals(new JComboBox().getClass()) && ((JComboBox) arrayList.get(i)).getSelectedIndex() == 0)) { // If component is a JComboBox & WideComboBox
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                    if(i <= 8) {
                        panelScroll.getViewport().setViewPosition(new Point(0,0));
                    } else {
                        panelScroll.getViewport().setViewPosition(new Point(0,345));
                    }
                }
            } else if(arrayList.get(i).getClass().equals(new JFormattedTextField().getClass()) && ((JFormattedTextField) arrayList.get(i)).getValue() == null) { // If component is a JFormattedTextField
                if(!putFocus) { // Set focus to this component
                    putFocus = true;
                    arrayList.get(i).requestFocus();
                    if(i <= 8) {
                        panelScroll.getViewport().setViewPosition(new Point(0,0));
                    } else {
                        panelScroll.getViewport().setViewPosition(new Point(0,345));
                    }
                }
            }
        }
        
    }

    public void requiredFieldsResetColor(final ArrayList<Component> arrayList) {
        
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getClass().equals(new JTextField().getClass())) { // If component is a JTextField
                arrayList.get(i).setBackground(Color.WHITE);
            } else if(arrayList.get(i).getClass().equals(new JDateChooser().getClass())) { // If component is a JDateChooser
                final JDateChooser dateField = (JDateChooser) arrayList.get(i);
                dateField.getComponent(0).setBackground(new Color(180, 180, 180));
                dateField.getComponent(1).setBackground(Color.WHITE);
            } else if(arrayList.get(i).getClass().equals(new WideComboBox().getClass()) ||
                      arrayList.get(i).getClass().equals(new JComboBox().getClass())) { // If component is a JComboBox & WideComboBox
                ((JComboBox) arrayList.get(i)).setSelectedIndex(0);
                arrayList.get(i).setBackground(new Color(150, 150, 150));
            } else if(arrayList.get(i).getClass().equals(new JFormattedTextField().getClass())) { // If component is a JFormattedTextField
                arrayList.get(i).setBackground(Color.WHITE);
            }
        }
        
    }

}
