package graphics;

import javax.swing.*;
import java.awt.*;

public class EndGamePopup extends JPopupMenu {

    @SuppressWarnings("FieldMayBeFinal")
    private JMenuItem menuItem;
    private final Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

    public EndGamePopup() {

        menuItem = new JMenuItem();
        menuItem.setFont(new Font("Robota", Font.BOLD, 20));
        add(menuItem);


    }

    public void setVictoryMessage(int numberAttempts) {
        String message = "Congratulazioni! Hai indovinato il codice segreto in " + numberAttempts + " mosse";
        menuItem.setText(message);
        setLocation(p.x - 350, 50);
        setVisible(true);
    }

    public void setLooseMessage(int[] secretCode) {
        String message = "Peccato! Hai terminato i tentativi. Il codice corretto è: " +
                Colors.values()[secretCode[0]].getNomeColore() + ", " +
                Colors.values()[secretCode[1]].getNomeColore() + ", " +
                Colors.values()[secretCode[2]].getNomeColore() + ", " +
                Colors.values()[secretCode[3]].getNomeColore();
        menuItem.setText(message);
        setLocation(p.x - 300, 50);
        setVisible(true);
    }

}
