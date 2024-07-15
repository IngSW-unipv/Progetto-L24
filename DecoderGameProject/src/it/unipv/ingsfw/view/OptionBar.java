package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Classe che rappresenta il menu con l' impostazione della difficoltà.
 * Estende la classe JMenuBar per la gestione delle impostazioni grafiche
 * e del comportamento dei componenti.
 */

public class OptionBar extends JMenuBar {

    JMenu firstMenu;
    JRadioButton difficultyEasy;
    JRadioButton difficultyNormal;
    JRadioButton difficultyHard;
    JMenuItem setButton;
    ButtonGroup difficultyGroup;
    JLabel difficultyLabel;

    /**
     * Costruttore che definisce le proprietà grafiche e dell'organizzazione
     * dei sotto-componenti della barra dei menu.
     */

    public OptionBar() {

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
        firstMenu.add(setButton);
    }

    /**
     * Aggiunge un ActionListener al pulsante che gestisce la selezione della difficoltà.
     * Quando il pulsante viene premuto, l'ActionListener fornito sarà notificato.
     *
     * @param listener l'ActionListener da associare al pulsante della difficoltà
     */

    public void addDifficultyButtonListener(ActionListener listener) {
        setButton.addActionListener(listener);
    }

    /**
     * Restituisce la difficoltà attualmente selezionata dall'utente.
     * Se nessuna delle opzioni di difficoltà è selezionata, restituisce una stringa vuota
     * per impostazione predefinita.
     *
     * @return una stringa rappresentante la difficoltà selezionata ("EASY", "NORMAL" o "HARD")
     */

    public String getDifficulty() {
        if(difficultyEasy.isSelected()) {
            return "EASY";
        } else if (difficultyNormal.isSelected()) {
            return "NORMAL";
        } else if(difficultyHard.isSelected()) {
            return "HARD";
        } else {
            return "";
        }
    }
}
