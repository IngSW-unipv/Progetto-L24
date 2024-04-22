package Graphics;

import javax.swing.*;
import java.awt.*;

public class DropMenu extends JComboBox {

    DropMenu() {

        String[] colori = {"rosso", "verde", "blu", "viola", "bianco", "nero"};
        Font fontTestoColori = new Font("Arial Black", Font.PLAIN, 12);

        setBounds(0, 0, 250, 50);
        setFont(fontTestoColori);

        for(String i: colori) {

            addItem(i);

        }
    }


}
