package it.unipv.ingsfw.view;   //Definisce il package in cui si trova la classe ComboBox
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

/**
 * Componente interattivo dell'interfaccia di gioco impiegato per la scelta dei colori del tentativo corrente.
 */
public class ComboBox extends JComboBox<String> {

//    Costruttore:

    /**
     * Definizione delle proprietà grafiche del componente.
     * @param colors
     * Elenco dei colori ammessi come pioli codice.
     */
    public ComboBox(String[] colors) {
//        aggiunta colori al menu a tendina
        super(colors);
        setFont(new Font("Inconsolata", Font.BOLD, 20));
    }
}
