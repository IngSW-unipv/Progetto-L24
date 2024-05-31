package graphics;   //Definisce il package in cui si trova la classe ComboBox
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String> {

//    Costruttore:

    public ComboBox(String[] colors) {
//        aggiunta colori al menu a tendina
        super(colors);
        setFont(new Font("Inconsolata", Font.BOLD, 20));
    }
}
