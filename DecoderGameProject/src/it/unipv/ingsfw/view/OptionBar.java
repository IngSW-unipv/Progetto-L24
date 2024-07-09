package it.unipv.ingsfw.view;   //Definisce il package in cui si trova la classe OptionBar
// importazioni utili alla corretta definizione aspetti grafici
import graphics.AttemptsListener;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Componente interattivo dell'interfaccia adibito alla scelta della difficoltà.
 */
public class OptionBar extends JMenuBar {

//    Definizioni:

    /**
     * Primo menu della barra.
     */
    JMenu firstMenu;
    /**
     * Bottone di scelta della difficoltà facile.
     */
    JRadioButton difficultyEasy;
    /**
     * Bottone di scelta della difficoltà normale.
     */
    JRadioButton difficultyNormal;
    /**
     * Bottone di scelta della difficoltà difficile.
     */
    JRadioButton difficultyHard;
    /**
     * Bottone di conferma della difficoltà.
     */
    JMenuItem setButton;
    /**
     * Gruppo dei bottoni di scelta della difficoltà.
     */
    ButtonGroup difficultyGroup;
    /**
     * Etichetta di descrizione del menu.
     */
    JLabel difficultyLabel;

//    Costruttore:

    /**
     * Definizione delle proprietà grafiche e dell'organizzazione dei sotto-componenti della barra dei menu.
     */
    public OptionBar() {

//        Inizializzazioni:

        firstMenu = new JMenu("File");
        difficultyGroup = new ButtonGroup();
        difficultyEasy = new JRadioButton("Facile");
        difficultyNormal = new JRadioButton("Normale");
        difficultyHard = new JRadioButton("Difficile");
        difficultyLabel = new JLabel("Selezione difficoltà");
        setButton = new JMenuItem("Conferma impostazioni");

//        Definizioni proprietà:

        firstMenu.getAccessibleContext().setAccessibleDescription("Impostazioni generali");
        difficultyEasy.setSelected(true);

//        Inserimenti per layout:

        this.add(firstMenu);

        firstMenu.add(difficultyLabel);
        difficultyGroup.add(difficultyEasy);
        firstMenu.add(difficultyEasy);
        difficultyGroup.add(difficultyNormal);
        firstMenu.add(difficultyNormal);
        difficultyGroup.add(difficultyHard);
        firstMenu.add(difficultyHard);
        firstMenu.addSeparator();
    }

    public void addSetButtonListener(ActionListener listener) {
        setButton.addActionListener(listener);
    }

    public String getDifficulty() {
        if(difficultyEasy.isSelected()) {
            return "EASY";
        } else if (difficultyNormal.isSelected()) {
            return "NORMAL";
        } else {
            return "HARD";
        }
    }
}
