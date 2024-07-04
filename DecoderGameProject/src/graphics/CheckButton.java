package graphics;   //Definisce il package in cui si trova la classe CheckButton
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

/**
 * Componente interattivo dell'interfaccia di gioco per la conferma del tentativo corrente.
 */
public class CheckButton extends JButton{
//    Costruttore:

    /**
     * Definizione caratteristiche grafiche del bottone.
     */
     public CheckButton() {
//         definizione scritta bottone
         super("''Check sequence''");
//         definizione font del bottone
         setFont(new Font("Inconsolata", Font.ITALIC, 25));

     }
}
