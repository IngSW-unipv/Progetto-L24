package Graphics;

import javax.swing.table.AbstractTableModel;

public class TableModelWhite extends AbstractTableModel {

    int attempts;

    String columnName = "White key poles";

    public TableModelWhite(int attempts) {

        this.attempts = attempts;

    }

    @Override
    public String getColumnName(int column) {
        return columnName;
    }

    @Override
    public int getRowCount() {
        return attempts;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
