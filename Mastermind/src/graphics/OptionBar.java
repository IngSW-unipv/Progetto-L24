package graphics;   //Definisce il package in cui si trova la classe OptionBar
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;

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
    /**
     * Definizione dell'interfaccia di collegamento con il pannello di gioco.
     */
    private AttemptsListener attemptsListener;

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

//        definizione azioni alla pressione del tasto di conferma

        setButton.addActionListener(e -> {
//            scelta del numero di tentativi in base alla difficoltà selezionata
            if(difficultyEasy.isSelected()) {
                attemptsListener.difficultyChoose(15);
            } else if (difficultyNormal.isSelected()) {
                attemptsListener.difficultyChoose(10);
            } else {
              attemptsListener.difficultyChoose(5);
            }
        });
        firstMenu.add(setButton);
    }

    /**
     * Definizione del controller di collegamento con l'interfaccia di gioco.
     * @param attemptsListener
     * Interfaccia di collegamento.
     */
    public void setAttemptsListener(AttemptsListener attemptsListener) {

        this.attemptsListener = attemptsListener;

    }
}
