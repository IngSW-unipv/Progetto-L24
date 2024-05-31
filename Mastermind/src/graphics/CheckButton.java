package graphics;   //Definisce il package in cui si trova la classe CheckButton
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

public class CheckButton extends JButton{
//    Costruttore:

     public CheckButton() {
//         definizione scritta bottone
         super("''Check sequence''");
         setFont(new Font("Inconsolata", Font.ITALIC, 25));

     }
}
