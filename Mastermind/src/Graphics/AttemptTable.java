package Graphics;

import javax.swing.*;
import java.awt.*;

public class AttemptTable extends JTable {

    JPopupMenu endLine;

    public AttemptTable(AttemptTableModel attemptTableModel) {

        super(attemptTableModel);
        AttemptTableCellRenderer attemptTableCellRenderer = new AttemptTableCellRenderer();
        this.setDefaultRenderer(Object.class, attemptTableCellRenderer);
        setCellSelectionEnabled(false);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        endLine = new JPopupMenu();
        endLine.setFont(new Font("Robota", Font.ITALIC, 14));
    }

}
