/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author egrubellano
 */
public class ClassTableHeaderRendererCheckbox extends JCheckBox implements TableCellRenderer {

    enum Status {

        SELECTED, DESELECTED, INDETERMINATE
    };

    public ClassTableHeaderRendererCheckbox(JTableHeader header, final int targetColumnIndex) {

        super((String) null);
        setOpaque(false);
        setFont(header.getFont());

        header.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = (JTableHeader) e.getSource();
                JTable table = header.getTable();
                TableColumnModel columnModel = table.getColumnModel();
                int vci = columnModel.getColumnIndexAtX(e.getX());
                int mci = table.convertColumnIndexToModel(vci);

                if (mci == targetColumnIndex) {

                    TableColumn column = columnModel.getColumn(vci);
                    Object v = column.getHeaderValue();
                    boolean b = Status.DESELECTED.equals(v);
                    TableModel m = table.getModel();

                    for (int i = 0; i < m.getRowCount(); i++) {

                        m.setValueAt(b, i, mci);
                    }

                    column.setHeaderValue(b ? Status.SELECTED : Status.DESELECTED);
                }
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable tbl, Object val, boolean isS, boolean hasF, int row, int col) {

        if (val instanceof Status) {

            switch ((Status) val) {

                case SELECTED:
                    setSelected(true);
                    setEnabled(true);
                    break;
                case DESELECTED:
                    setSelected(false);
                    setEnabled(true);
                    break;
                case INDETERMINATE:
                    setSelected(true);
                    setEnabled(false);
                    break;
            }
        } else {

            setSelected(true);
            setEnabled(false);
        }

        TableCellRenderer r = tbl.getTableHeader().getDefaultRenderer();
        JLabel l = (JLabel) r.getTableCellRendererComponent(tbl, null, isS, hasF, row, col);

        l.setIcon(new CheckBoxIcon(this));
        l.setText(null); // XXX Nimbus LnF ???
        // // This block has no effect at all as all the columns are center aligned
        // // (pointed out by rcnpl)
        // if(tbl.convertColumnIndexToModel(col)==0) {
        //   l.setHorizontalAlignment(SwingConstants.CENTER);
        // } else {
        //   l.setHorizontalAlignment(SwingConstants.LEFT);
        // }
        // <ins>
        l.setHorizontalAlignment(SwingConstants.CENTER);
        // </ins>

        return l;
    }

    class CheckBoxIcon implements Icon {

        private final JCheckBox check;

        public CheckBoxIcon(JCheckBox check) {
            this.check = check;
        }

        @Override
        public int getIconWidth() {
            return check.getPreferredSize().width;
        }

        @Override
        public int getIconHeight() {
            return check.getPreferredSize().height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            SwingUtilities.paintComponent(
                    g, check, (Container) c, x, y, getIconWidth(), getIconHeight());
        }
    }

}
