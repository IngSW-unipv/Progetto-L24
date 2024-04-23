package Graphics;

import javax.swing.table.AbstractTableModel;

public class TableModelAttempt extends AbstractTableModel {

    int attempts;
    String[] columnNames = {"Red key poles", "Pin 1", "Pin 2", "Pin 3", "Pin 4", "White key poles"};
    int[][] sequences, hints;

    public TableModelAttempt(int attempts) {
        this.attempts = attempts;
         sequences = new int[attempts][4];
         hints = new int[attempts][2];
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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setSequence(int row, int column, int color) {
        sequences[row][column] = color;
    }
    public int[] getSequence(int row) {
        return sequences[row];
    }
}
