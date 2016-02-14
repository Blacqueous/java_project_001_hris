/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author egrubellano
 */
public class ClassJTableCustomCellRenderer {
    
    public TableCellRenderer CheckboxCellRenderer(final Color odd, final Color even, final Color selColor) {
        
        return new TableCellRenderer() {
            private final javax.swing.JCheckBox DEFAULT_CHECKBOX = new javax.swing.JCheckBox();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                DEFAULT_CHECKBOX.setSelected((Boolean)value);
                DEFAULT_CHECKBOX.setHorizontalAlignment(SwingConstants.CENTER);
                DEFAULT_CHECKBOX.setOpaque(true);
                
                if(row%2 == 0) {
                    DEFAULT_CHECKBOX.setBackground(odd);
                } else {
                    DEFAULT_CHECKBOX.setBackground(even);
                }
                
                if(isSelected) {
                    DEFAULT_CHECKBOX.setBackground(selColor);
                }
                
                return DEFAULT_CHECKBOX;
            }
        };
        
    }

    public TableCellRenderer StringCellRenderer(final Color odd, final Color even, final Color selColor) {
        
        return new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                Component DEFAULT_COMPONENT = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if(row%2 == 0) {
                    DEFAULT_COMPONENT.setBackground(odd);
                } else {
                    DEFAULT_COMPONENT.setBackground(even);
                }
                
                if(isSelected) {
                    DEFAULT_COMPONENT.setBackground(selColor);
                }
                
                switch(column) {
                    case 3:
                        DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.LEFT);
                        break;
                    default:
                        DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.CENTER);
                        break;
                }
                
                return DEFAULT_COMPONENT;
            }
        };
        
    }
    
}
