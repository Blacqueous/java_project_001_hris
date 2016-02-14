/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author egrubellano
 */
public class ClassTableButtonRenderer extends JButton implements TableCellRenderer {

    protected boolean isPushed;
    protected Color oddColor;
    protected Color evenColor;
    protected Color selectedColor;
    protected JButton button;
    protected JTable table;
    protected String label;
    protected String action;

    public ClassTableButtonRenderer(final ImageIcon icon, final Color odd, final Color even, final Color selColor) {
        
        this.oddColor = odd;
        this.evenColor = even;
        this.selectedColor = selColor;
        
        setOpaque(true);
        setIcon(icon);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        isPushed = true;
        
        if(row%2 == 0) {
            setBackground(oddColor);
        } else {
            setBackground(evenColor);
        }
        
        if(isSelected) {
            setBackground(selectedColor);
        }
        
        label = (value == null) ? "" : value.toString();
        setText(label);
        
        return this;
    }

}
