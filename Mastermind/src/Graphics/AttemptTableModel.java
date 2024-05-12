package Graphics;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class AttemptTableModel extends AbstractTableModel {

    int attempts;
    String[] columnNames = {"Pos. errata", "1°colore", "2°colore", "3°colore", "4°colore", "Pos. corretta"};
    private static Color[][] cellColors;
    private static int[][] hints;


    public AttemptTableModel(int attempts) {
        this.attempts = attempts;
        cellColors = new Color[attempts][4];
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                hints[rowIndex][0] = (int) aValue;
                break;
            case 5:
                hints[rowIndex][1] = (int) aValue;
                break;
            default:
                break;
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

     public void setCellColor(int row, int column, Color color) {

        cellColors[row][column-1] = color;
        fireTableCellUpdated(row, column);
    }

    public static Color getCellColor(int row, int column) {
        if(column != 0 && column != 5) {
            return cellColors[row][column-1];
        }
        else {
            return Color.white;
        }
    }

    public void setHints(int row, int[] hint) {
        System.arraycopy(hint,0,hints[row],0,hint.length);
        fireTableCellUpdated(row,0);
        fireTableCellUpdated(row,5);
    }
    public static int getHints(int row, int column) {
        return hints[row][column];
    }

}