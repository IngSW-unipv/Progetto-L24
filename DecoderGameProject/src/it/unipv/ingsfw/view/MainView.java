package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * La classe MainView rappresenta la finestra principale dell'applicazione Decoding Game.
 * Contiene vari pannelli e componenti per mostrare le informazioni di gioco.
 */

public class MainView extends JFrame {

    private final JPanel choicePanel;
    private final JLabel infoLabel;
    private final OptionBar optionBar;
    private final AttemptsTable attemptsTable;
    private final ComboBox[] comboBoxes;
    private final CheckButton checkButton;
    private final String mask1 = "Game N. ";
    private final String mask2 = " Decoder name: ";
    private final String mask3 = " Points: ";

    /**
     * Costruttore della classe MainView che inizializza la finestra principale.
     * Imposta il titolo, le dimensioni e inizializza tutti i componenti grafici.
     */

    public MainView() {
        super("Decoding Game");
        setSize(800, 470);

        JPanel centerPanel = new JPanel();
        choicePanel = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());
        infoLabel = new JLabel(mask1, SwingConstants.CENTER);
        infoLabel.setFont(new Font("Inconsolata", Font.BOLD, 16));
        infoLabel.setVisible(false);
        optionBar = new OptionBar();
        optionBar.setEnabled(false);
        attemptsTable = new AttemptsTable(new AttemptsTableModel(0));
        attemptsTable.getTableHeader().setDefaultRenderer(new MainHeaderRenderer());
        attemptsTable.getTableHeader().getColumnModel()
                .getColumn(0).setHeaderRenderer(new WrongPosHeaderRenderer());
        attemptsTable.getTableHeader().getColumnModel()
                        .getColumn(5).setHeaderRenderer(new RightPosHeaderRenderer());
        comboBoxes = new ComboBox[4];
        checkButton = new CheckButton();
        centerPanel.add(infoLabel, BorderLayout.PAGE_START);
        centerPanel.add(new JScrollPane(attemptsTable), BorderLayout.CENTER);
        centerPanel.add(choicePanel, BorderLayout.PAGE_END);
        add(optionBar, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(checkButton, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Aggiunge le informazioni di gioco (ID, nome del decoder, punti del decoder) all'etichetta delle informazioni.
     *
     * @param gameID       l'ID del gioco corrente.
     * @param decoderName  il nome del decoder.
     * @param decoderPoints i punti del decoder.
     */

    public void addTextInfo(int gameID, String decoderName, int decoderPoints) {
        infoLabel.setText("");
        String builder = mask1 + gameID +
                mask2 +
                decoderName +
                mask3 +
                decoderPoints;
        infoLabel.setText(builder);
        infoLabel.setVisible(true);
    }

    /**
     * Imposta la visibilità della finestra principale.
     *
     * @param visible true se la finestra deve essere visibile, false altrimenti.
     */

    public void defineVisibility(Boolean visible) {
        this.setVisible(visible);
    }

    /**
     * Restituisce l'istanza di OptionBar associata alla finestra principale.
     *
     * @return l'istanza di OptionBar.
     */

    public OptionBar getOptionBar() {
        return this.optionBar;
    }

    /**
     * Restituisce l'istanza di AttemptsTable associata alla finestra principale.
     *
     * @return l'istanza di AttemptsTable.
     */

    public AttemptsTable getAttemptsTable() {
        return this.attemptsTable;
    }

    /**
     * Restituisce l'istanza di CheckButton associata alla finestra principale.
     *
     * @return l'istanza di CheckButton.
     */

    public CheckButton getCheckButton() {
        return this.checkButton;
    }

    /**
     * Restituisce un array di ComboBox utilizzati per la selezione dei colori.
     *
     * @return l'array di ComboBox.
     */

    public ComboBox[] getComboBoxes() {
        return this.comboBoxes;
    }

    /**
     * Imposta nella tabella degli attempts il numero di righe relativo al numero specificato di tentativi.
     *
     * @param attempts il numero di tentativi da mostrare nella tabella.
     */

    public void setupAttemptsTable(int attempts) {
        this.getAttemptsTable().setModel(new AttemptsTableModel(attempts));
        this.getAttemptsTable().getTableHeader().getColumnModel().
                getColumn(0).setHeaderRenderer(new WrongPosHeaderRenderer());
        this.getAttemptsTable().getTableHeader().getColumnModel().
                getColumn(5).setHeaderRenderer(new RightPosHeaderRenderer());
    }

    /**
     * Mostra un messaggio di vittoria con il numero di tentativi usati.
     *
     * @param attemptsUsed il numero di tentativi utilizzati per vincere il gioco.
     */

    public void victoryMessage(int attemptsUsed) {
        JOptionPane.showMessageDialog(this, "Congratulation! You win this game in " +
                attemptsUsed + " attempts");
    }

    /**
     * Mostra un messaggio di sconfitta con il codice segreto.
     *
     * @param secretCode l'elenco di colori del codice segreto.
     */

    public void looseMessage(ArrayList<String> secretCode) {
        JOptionPane.showMessageDialog(this, "No more attempts left!\nSecret code was: " +
                secretCode.toString());
    }

    /**
     * Mostra un messaggio di errore riguardante la scelta della difficoltà del gioco.
     */

    public void difficultyError() {
        JOptionPane.showMessageDialog(this, "Error: Choose a game difficulty first!");
    }

    /**
     * Verifica la presenza di duplicati nella sequenza selezionata.
     *
     * @return true se non ci sono duplicati, false altrimenti.
     */

    public Boolean checkDuplicateInSequence() {
        return Stream.of(getComboBoxes()[1], getComboBoxes()[2], getComboBoxes()[3]).
                noneMatch(comboBox -> getComboBoxes()[0].
                        getSelectedIndex() == comboBox.getSelectedIndex())
                && Stream.of(getComboBoxes()[0], getComboBoxes()[2], getComboBoxes()[3]).
                noneMatch(comboBox -> getComboBoxes()[1].
                        getSelectedIndex() == comboBox.getSelectedIndex())
                && Stream.of(getComboBoxes()[0], getComboBoxes()[1], getComboBoxes()[3]).
                noneMatch(comboBox -> getComboBoxes()[2].
                        getSelectedIndex() == comboBox.getSelectedIndex())
                && Stream.of(getComboBoxes()[0], getComboBoxes()[1], getComboBoxes()[2]).
                noneMatch(comboBox -> getComboBoxes()[3].
                        getSelectedIndex() == comboBox.getSelectedIndex());
    }

    /**
     * Popola gli array di ComboBox con la lista di nomi di colori fornita.
     *
     * @param list l' array di stringhe contenente i nomi dei colori.
     */

    public void getColorList(String[] list) {
        for(int i = 0; i < comboBoxes.length; i++) {
            this.comboBoxes[i] = new ComboBox(list);
            this.choicePanel.add(comboBoxes[i]);
        }
    }
}
