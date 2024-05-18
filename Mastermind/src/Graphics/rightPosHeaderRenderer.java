package Graphics;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class rightPosHeaderRenderer extends JLabel implements TableCellRenderer {

    public rightPosHeaderRenderer() {

        setFont(new Font("Inconsolata", Font.BOLD, 14));
        setOpaque(true);
        setBackground(new Color(0,255,0));
        setBorder(BorderFactory.createEtchedBorder());

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
