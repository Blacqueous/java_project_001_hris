/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author egrubellano
 */
public class ClassTableHeaderRendererAlignCenter implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable t, Object v, boolean isS, boolean hasF, int row, int col) {

        TableCellRenderer r = t.getTableHeader().getDefaultRenderer();
        JLabel l = (JLabel) r.getTableCellRendererComponent(t, v, isS, hasF, row, col);
        l.setHorizontalAlignment(SwingConstants.CENTER);

        return l;
    }

}
