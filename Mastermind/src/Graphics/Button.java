package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {

    private SequenceListener sequenceListener;

    public Button() {
        super("Check");
    }

    public void setSequenceListener(SequenceListener sequenceListener) {
    this.sequenceListener = sequenceListener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
