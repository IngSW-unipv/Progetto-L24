package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe che rappresenta il bottone da premere per eseguire la valutazione di una sequenza.
 * Estende la classe JButton per gestire le componenti grafiche del bottone e il comportamento.
 */
public class CheckButton extends JButton{

    /**
     * Costruttore che definisce le caratteristiche grafiche del bottone.
     */
     public CheckButton() {
//         definizione scritta bottone
         super("''Check sequence''");
//         definizione font del bottone
         setFont(new Font("Inconsolata", Font.ITALIC, 25));

     }
}
