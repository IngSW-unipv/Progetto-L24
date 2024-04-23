package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame {

    int attemptN;
    CenterTablePanel centerTablePanel;
    JPanel bottomPanel, centerPanel;
    DropMenu dropMenu1;
    DropMenu dropMenu2;
    DropMenu dropMenu3;
    DropMenu dropMenu4;
    JButton button;

    public MainGui(int attempts) {
        super("Mastermind");
        attemptN = 0;
        Dimension dim = new Dimension(600, 300);
        setLayout(new BorderLayout());

        centerTablePanel = new CenterTablePanel(attempts);
        bottomPanel = new JPanel(new FlowLayout());
        centerPanel = new JPanel(new BorderLayout());
        dropMenu1 = new DropMenu();
        dropMenu2 = new DropMenu();
        dropMenu3 = new DropMenu();
        dropMenu4 = new DropMenu();
        button = new JButton("Conferma");

        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(centerTablePanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.add(dropMenu1);
        bottomPanel.add(dropMenu2);
        bottomPanel.add(dropMenu3);
        bottomPanel.add(dropMenu4);
        add(button, BorderLayout.PAGE_END);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] seq = new int[4];
                seq[0] = dropMenu1.getSelectedIndex();
                seq[1] = dropMenu2.getSelectedIndex();
                seq[2] = dropMenu3.getSelectedIndex();
                seq[3] = dropMenu4.getSelectedIndex();
            }
        });

        setSize(dim);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}
