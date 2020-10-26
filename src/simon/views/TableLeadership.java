/**
 * 
 */
package simon.views;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Zac
 *
 */
public class TableLeadership extends JTable {

    private TableRowSorter<TableModel> sorter;
    Object[][] data = { { "Kathy", 2 }, { "John", 8 }, { "Sue", 5 }, { "Jane", 3 }, { "Joe", 4 } };
    String[] columnNames = { "Name", "Highscores" };

    public TableLeadership() {
        initialize();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 1)
            return Integer.class;
        return super.getColumnClass(column);
    }

    private void initialize() {
        TableModel model = new DefaultTableModel(data, columnNames);
        setModel(model);
        setRowSelectionAllowed(false);
        setFillsViewportHeight(true);
        getTableHeader().setEnabled(false);
        sorter = new TableRowSorter<TableModel>(getModel());
        setRowSorter(sorter);
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer int1, Integer int2) {
                return int1.compareTo(int2);
            }

        };
        sorter.setComparator(1, comparator);
        ArrayList<RowSorter.SortKey> list = new ArrayList<RowSorter.SortKey>();
        list.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(list);
        sorter.sort();
    }

    public boolean addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        // Check if name already exists in leadership board
        for (int i = 0; i < model.getRowCount(); i++) {
            String value = (String) model.getValueAt(i, 0);
            if (value.equalsIgnoreCase((String) row[0])) { // Name already exist
                model.setValueAt(row[1], i, 1);
                this.sorter.sort();
                return false;
            }
        }
        // New name, add new row
        model.addRow(row);
        this.sorter.sort();
        return true;
    }

}
