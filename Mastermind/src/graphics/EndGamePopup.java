package graphics;   //Definisce il package in cui è contenuta la classe EndGamePopup
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

/**
 * Popup descrittivo della situazione di gioco a fine partita.
 */
public class EndGamePopup extends JPopupMenu {
//    Definizioni:

    /**
     * Componente del popup che permette la visualizzazione del messaggio di fine partita.
     */
    @SuppressWarnings("FieldMayBeFinal")
    private JMenuItem menuItem;
    /**
     * Coordinate del centro dello schermo per la definizione della posizione e dimensione del popup.
     */
    private final Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

    /**
     * Definizione delle caratteristiche e delle proprietà del popup.
     */
    public EndGamePopup() {
//        Inizializzazioni:

        menuItem = new JMenuItem();
        menuItem.setFont(new Font("Robota", Font.BOLD, 20));
        add(menuItem);


    }

    /**
     * Definizione del messaggio di vittoria e delle proprietà grafiche del popup.
     * @param numberAttempts
     * Numero di tentativi impiegati dal giocatore per vincere.
     */
    public void setVictoryMessage(int numberAttempts) {
//        impostazione stringa messaggio in menuItem
        String message = "Congratulazioni! Hai indovinato il codice segreto in " + numberAttempts + " mosse";
        menuItem.setText(message);
//        impostazione posizione del popup sullo schermo
        setLocation(p.x - 350, 50);
//        impostazione di visibilità
        setVisible(true);
    }

    /**
     * Definizione del messaggio di sconfitta e delle proprietà grafiche del popup.
     * @param secretCode
     * Codice segreto non individuato dal giocatore nei tentativi stabiliti.
     */
    public void setLooseMessage(int[] secretCode) {
//        impostazione stringa messaggio in menuItem con valori del codice segreto
        String message = "Peccato! Hai terminato i tentativi. Il codice corretto è: " +
                Colors.values()[secretCode[0]].getNomeColore() + ", " +
                Colors.values()[secretCode[1]].getNomeColore() + ", " +
                Colors.values()[secretCode[2]].getNomeColore() + ", " +
                Colors.values()[secretCode[3]].getNomeColore();
        menuItem.setText(message);
//        impostazione posizione del popup sullo schermo
        setLocation(p.x - 300, 50);
//        impostazione di visibilità
        setVisible(true);
    }

}
