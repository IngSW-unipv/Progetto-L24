package graphics;   //Definisce il package in cui si trova la classe OptionBar
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;

public class OptionBar extends JMenuBar {

//    Definizioni:

//    primo menu principale
    JMenu firstMenu;
//    serie di bottoni per la scelta della difficoltà
    JRadioButton difficultyEasy;
    JRadioButton difficultyNormal;
    JRadioButton difficultyHard;
//    bottone di conferma delle impostazioni scelte
    JMenuItem setButton;
//    gruppo bottoni difficoltà
    ButtonGroup difficultyGroup;
//    etichetta descrittiva difficoltà
    JLabel difficultyLabel;
//    istanza di interfaccia utile al passaggio del numero
//    di tentativi all'interfaccia grafica principale
    private AttemptsListener attemptsListener;

//    Costruttore:

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

//    metodo per la definizione dell'istanza di interfaccia

public void setAttemptsListener(AttemptsListener attemptsListener) {

        this.attemptsListener = attemptsListener;

    }
}
