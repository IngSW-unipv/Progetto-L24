package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe che rappresenta il menu a tendina utilizzato per la scelta dei colori nelle sequenze.
 * Estende la classe JComboBox per gestire le componenti grafiche e il comportamento del menu.
 */
public class ComboBox extends JComboBox<String> {

    /**
     * Costruttore che definisce le proprietà grafiche del menu.
     * @param colors Elenco dei colori ammessi.
     */
    public ComboBox(String[] colors) {
//        aggiunta colori al menu a tendina
        super(colors);
        setFont(new Font("Inconsolata", Font.BOLD, 20));
    }
}
