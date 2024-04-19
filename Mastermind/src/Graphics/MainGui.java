package Graphics;

import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    CenterTablePanel centerTablePanel;

    public MainGui(int attempts) {
        super("Mastermind");
        Dimension dim = new Dimension(600, 500);
        setLayout(new BorderLayout());

        centerTablePanel = new CenterTablePanel(attempts);
        add(centerTablePanel, BorderLayout.CENTER);

        setSize(dim);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}
