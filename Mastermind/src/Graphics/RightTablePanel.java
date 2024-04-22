package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RightTablePanel extends JPanel {

    TableModelWhite tableModelWhite;

    public RightTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 100;
        setPreferredSize(dim);

        Border border = BorderFactory.createLineBorder(Color.white);

        tableModelWhite = new TableModelWhite(attempts);
        JTable table = new JTable(tableModelWhite);

        setBorder(border);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

    }

}
