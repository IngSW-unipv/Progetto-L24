package Graphics;   //Definisce il package in cui si trova la classe ComboBox
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;

public class ComboBox extends JComboBox<String> {

//    Costruttore:

    public ComboBox(String[] colors) {
//        aggiunta colori al menu a tendina
        super(colors);
    }
}
