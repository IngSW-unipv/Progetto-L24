package Graphics;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainHeaderRenderer extends JLabel implements TableCellRenderer {

    public MainHeaderRenderer() {

        setFont(new Font("Inconsolata", Font.BOLD, 14));
        setOpaque(true);
        setForeground(Color.white);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createEtchedBorder());

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
