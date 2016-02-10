/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author egrubellano
 */
public class ClassTableButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private String action;
        private boolean isPushed;
        public JTable table;

        public ClassTableButtonEditor(JCheckBox checkBox, ImageIcon icon) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getModifiers() == 16) {
                        fireEditingStopped();
                    }
                }
            });
            button.setIcon(icon);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                pushAction();
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

        public JTable getTable(){
            return table;
        }
        
        public void setTable(JTable tbl){
            table = tbl;
        }

        public void setPushAction(String actn) {
            action = actn;
        }

        public void pushAction() {

            switch(action) {
//            JOptionPane.showMessageDialog(button, label + ": " + table.getModel().getValueAt(table.getSelectedRow(), 2));
                case "Search_Update" :

                    int valueUpdate = JOptionPane.showOptionDialog(button, "Update this account?", "Are you sure?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Update", "Cancel"}, null );
                    
                    if(valueUpdate == 0) {
                        System.out.println("Update id : " + table.getModel() .getValueAt(table.getSelectedRow(), 0));
                    }
                    
                    break;

                case "Search_Delete" :

//                    int valueDelete = JOptionPane.showOptionDialog(button, "Delete this account?", "Are you sure?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Delete", "View", "Cancel"}, null );
//                    
//                    if(valueDelete == 0) {
//                        System.out.println("Delete id : " + table.getModel().getValueAt(table.getSelectedRow(), 0));
//                    } else if(valueDelete == 1) {
//                        System.out.println("View deleting id : " + table.getModel().getValueAt(table.getSelectedRow(), 0));
//                    }
//
//                    break;

                    int valueDelete = JOptionPane.showOptionDialog(button, "Delete this account?", "Are you sure?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Delete", "Cancel"}, null );
                    
                    if(valueDelete == 0) {
                        System.out.println("Delete id : " + table.getModel().getValueAt(table.getSelectedRow(), 0));
                    }

                    break;

                case "Search_Print" :

//                    int valuePrint = JOptionPane.showOptionDialog(button, "Delete this account?", "Are you sure?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Print", "Cancel"}, null );
                    
//                    if(valuePrint == 0) {
                        System.out.println("Print user with id : " + table.getModel().getValueAt(table.getSelectedRow(), 0));
//                    }

                    break;

                case "Table_Remove" :

                    DefaultTableModel tm = (DefaultTableModel)table.getModel();
                    System.out.println(tm);
                    System.out.println(table.convertRowIndexToModel(table.getSelectedRow()));
//                    tm.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));

//                    table.setModel(tm);
//                    table.repaint();

                    break;
            }
        }

}
