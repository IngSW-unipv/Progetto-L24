package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LeftTablePanel extends JPanel {

    TableModelRed tableModelRed;

    public LeftTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 100;
        setPreferredSize(dim);

        Border border = BorderFactory.createLineBorder(Color.red);

        tableModelRed = new TableModelRed(attempts);
        JTable table = new JTable(tableModelRed);

        setBorder(border);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

    }

}
