package Graphics;

import javax.swing.table.AbstractTableModel;

public class TableModelAttempt extends AbstractTableModel {

    int attempts;
    String[] columnNames = {"Pin1", "Pin2", "Pin3", "Pin4"};

    public TableModelAttempt(int attempts) {
        this.attempts = attempts;

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return attempts;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
