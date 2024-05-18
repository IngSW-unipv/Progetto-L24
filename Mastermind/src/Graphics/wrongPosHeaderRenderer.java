package Graphics;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class wrongPosHeaderRenderer extends JLabel implements TableCellRenderer {

    public wrongPosHeaderRenderer() {

        setFont(new Font("Inconsolata", Font.BOLD, 14));
        setOpaque(true);
        setForeground(Color.black);
        setBackground(new Color(0,190,255));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
