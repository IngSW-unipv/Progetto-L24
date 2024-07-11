package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DecoderNameDialog extends JDialog {

    private final JTextField nameField;
    private final JButton confirmButton;

    public DecoderNameDialog(JFrame parent) {
        super(parent, "Insert your name", true);
        setSize(400, 100);
        setVisible(false);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        nameField = new JTextField();
        confirmButton = new JButton("Confirm name");

        panel.add(new JLabel("Insert a name for Decoder: "));
        panel.add(nameField);
        add(panel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
    }

    public String getDecoderName() {
        return nameField.getText();
    }

    public void addConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

}
