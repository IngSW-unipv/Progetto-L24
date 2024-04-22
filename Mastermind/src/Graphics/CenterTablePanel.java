package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CenterTablePanel extends JPanel {

    public CenterTablePanel(int attempts) {

//        Dimension dim = getPreferredSize();
//        dim.width = 200;
        setPreferredSize(getPreferredSize());
        Border border = BorderFactory.createLineBorder(Color.gray);
        setBorder(border);
        setLayout(new BorderLayout());

        add(new JScrollPane(new JTable(new TableModelAttempt(attempts))), BorderLayout.CENTER);

    }

}
