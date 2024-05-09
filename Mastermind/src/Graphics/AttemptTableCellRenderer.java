package Graphics;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AttemptTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color cellColor = AttemptTableModel.getCellColor(row, column);

        if (cellColor != null) {
            cellComponent.setBackground(cellColor);

        } else {
            cellComponent.setBackground(table.getBackground());
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    }
}
