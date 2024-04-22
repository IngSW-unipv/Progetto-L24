package Graphics;

import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    CenterTablePanel centerTablePanel;
    LeftTablePanel leftTablePanel;
    RightTablePanel rightTablePanel;
    JPanel panel;
    DropMenu dropMenu1;
    DropMenu dropMenu2;
    DropMenu dropMenu3;
    DropMenu dropMenu4;
    JButton button;

    public MainGui(int attempts) {
        super("Mastermind");
        Dimension dim = new Dimension(600, 500);
        setLayout(new BorderLayout());

        centerTablePanel = new CenterTablePanel(attempts);
        leftTablePanel = new LeftTablePanel(attempts);
        rightTablePanel = new RightTablePanel(attempts);
        panel = new JPanel(new FlowLayout());
        dropMenu1 = new DropMenu();
        dropMenu2 = new DropMenu();
        dropMenu3 = new DropMenu();
        dropMenu4 = new DropMenu();
        button = new JButton("Conferma");

        add(centerTablePanel, BorderLayout.CENTER);
        add(leftTablePanel, BorderLayout.LINE_START);
        add(rightTablePanel, BorderLayout.LINE_END);
        add(panel, BorderLayout.PAGE_END);
        centerTablePanel.add(panel, BorderLayout.PAGE_END);
        panel.add(dropMenu1);
        panel.add(dropMenu2);
        panel.add(dropMenu3);
        panel.add(dropMenu4);
        add(button, BorderLayout.PAGE_END);

        setSize(dim);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}
