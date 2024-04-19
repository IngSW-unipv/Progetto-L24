package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CenterTablePanel extends JPanel {

    private JTable table;
    private TableModelAttempt tableModelAttempt;

    public CenterTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 100;
        setPreferredSize(dim);

        Border border = BorderFactory.createLineBorder(Color.gray);

        tableModelAttempt = new TableModelAttempt(attempts);
        table = new JTable(tableModelAttempt);

        setBorder(border);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

    }

}
