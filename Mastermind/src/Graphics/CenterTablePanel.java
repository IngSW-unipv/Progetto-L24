package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CenterTablePanel extends JPanel {

    JTable table;

    public CenterTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);
        Border border = BorderFactory.createLineBorder(Color.gray);
        setBorder(border);
        setLayout(new BorderLayout());

        table = new JTable(new TableModelAttempt(attempts));
        table.getTableHeader().setDefaultRenderer(new DefaultHeaderRenderer());
        table.getColumnModel().getColumn(0).setHeaderRenderer(new RedKeyPolesHeaderRenderer());
        table.getColumnModel().getColumn(5).setHeaderRenderer(new WhiteKeyPolesHeaderRenderer());
        add(new JScrollPane(table), BorderLayout.CENTER);



    }

}
