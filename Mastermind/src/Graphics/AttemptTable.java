package Graphics;

import javax.swing.*;
import java.awt.*;

public class AttemptTable extends JTable {

    JPopupMenu endLine;

    public AttemptTable(AttemptTableModel attemptTableModel) {

        super(attemptTableModel);
        AttemptTableCellRenderer attemptTableCellRenderer = new AttemptTableCellRenderer();
        attemptTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.setDefaultRenderer(Object.class, attemptTableCellRenderer);
        setCellSelectionEnabled(false);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        setFont(new Font("Inconsolata", Font.BOLD, 16));
        endLine = new JPopupMenu();
        endLine.setFont(new Font("Robota", Font.ITALIC, 14));
    }

}
