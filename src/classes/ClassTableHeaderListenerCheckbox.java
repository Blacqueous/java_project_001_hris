/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author egrubellano
 */
public class ClassTableHeaderListenerCheckbox implements TableModelListener {

    enum Status {

        SELECTED, DESELECTED, INDETERMINATE
    };

    private final JTable table;
    protected int mci;

    public ClassTableHeaderListenerCheckbox(JTable table, int mci) {

        this.table = table;
        this.mci = mci;
    }

    @Override
    public void tableChanged(TableModelEvent e) {

        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == mci) {

            int vci = this.table.convertColumnIndexToView(this.mci);
            TableColumn column = this.table.getColumnModel().getColumn(vci);
            Object title = column.getHeaderValue();
            if (!Status.INDETERMINATE.equals(title)) {
                column.setHeaderValue(Status.INDETERMINATE);
            } else {

                int selected = 0, deselected = 0;
                TableModel m = this.table.getModel();

                for (int i = 0; i < m.getRowCount(); i++) {
                    if (Boolean.TRUE.equals(m.getValueAt(i, this.mci))) {
                        selected++;
                    } else {
                        deselected++;
                    }
                }

                if (selected == 0) {
                    column.setHeaderValue(Status.DESELECTED);
                } else if (deselected == 0) {
                    column.setHeaderValue(Status.SELECTED);
                } else {
                    return;
                }
            }

            this.table.getTableHeader().repaint();
        }
    }
}
