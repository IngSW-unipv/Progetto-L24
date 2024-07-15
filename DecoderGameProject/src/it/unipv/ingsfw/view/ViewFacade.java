package it.unipv.ingsfw.view;

import it.unipv.ingsfw.Observer;
import it.unipv.ingsfw.model.Colors;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La classe ViewFacade svolge la funzione di interfaccia generale per la visualizzazione del gioco.
 * Gestisce la visualizzazione dei cambiamenti del modello nelle schermate che la compongono.
 * Implementa l'interfaccia Observer per ricevere aggiornamenti sullo stato del gioco.
 */

public class ViewFacade implements Observer {

    private static ViewFacade instance;
    private final MainView mainview;
    private final DecoderNameDialog decoderNameDialog;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     * Inizializza la MainView e il DecoderNameDialog.
     */

    private ViewFacade() {
        mainview = new MainView();
        decoderNameDialog = new DecoderNameDialog(this.mainview);
//        System.out.println("View is ready!");
    }

    /**
     * Restituisce l'istanza singleton di ViewFacade.
     *
     * @return l'istanza di ViewFacade
     */

    public static ViewFacade getInstance() {
        if(instance == null) {
            instance = new ViewFacade();
        }
        return instance;
    }

    /**
     * Mostra la finestra principale del gioco.
     */

    public void showMainView() {
        mainview.setVisible(true);
    }

    /**
     * Mostra la schermata di dialogo per l'inserimento del nome del Decoder.
     */

    public void showDecoderNameDialog() {
        decoderNameDialog.setVisible(true);
    }

    /**
     * Nasconde la schermata di dialogo per l'inserimento del nome del Decoder
     * e abilita la barra delle opzioni.
     */

    public void hideDecoderNameDialog() {
        decoderNameDialog.setVisible(false);
        mainview.getOptionBar().setEnabled(true);
    }

    /**
     * Imposta la lista dei colori disponibili nella vista principale.
     *
     * @param colorList un array di stringhe rappresentanti i nomi dei colori
     */

    public void setColorList(String[] colorList) {
        this.getMainView().getColorList(colorList);
    }

    /**
     * Restituisce il nome del Decoder inserito nella schermata di dialogo per l'inserimento.
     *
     * @return il nome del Decoder
     */

    public String getDecoderName() {
        return decoderNameDialog.getDecoderName();
    }

    /**
     * Restituisce la difficoltà scelta dall'utente.
     *
     * @return una stringa rappresentante la difficoltà selezionata ("EASY", "NORMAL" o "HARD")
     */

    public String getDifficultyChosen() {
        return mainview.getOptionBar().getDifficulty();
    }

    /**
     * Applica la difficoltà scelta aggiornando il numero di tentativi nella tabella degli tentativi.
     *
     * @param attempts il numero di tentativi consentiti
     */

    public void applyDifficulty(int attempts) {
        mainview.setupAttemptsTable(attempts);
    }

    /**
     * Aggiunge un ActionListener al pulsante di conferma del nome del Decoder.
     *
     * @param listener l'ActionListener da associare al pulsante di conferma del nome
     */

    public void addConfirmNameButtonListener(ActionListener listener) {
        decoderNameDialog.addConfirmButtonListener(listener);
    }

    /**
     * Aggiunge un ActionListener al pulsante di impostazione della difficoltà.
     *
     * @param listener l'ActionListener da associare al pulsante di impostazione della difficoltà
     */

    public void addDifficultySetButtonListener(ActionListener listener) {
        mainview.getOptionBar().addDifficultyButtonListener(listener);
    }

    /**
     * Aggiunge un ActionListener al pulsante di controllo della sequenza.
     *
     * @param listener l'ActionListener da associare al pulsante di controllo della sequenza
     */

    public void addCheckSequenceButtonListener(ActionListener listener) {
        mainview.getCheckButton().addActionListener(listener);
    }

    /**
     * Mostra le informazioni del gioco (ID, nome del Decoder e punti) nella vista principale.
     *
     * @param gameID l'ID del gioco
     * @param decoderName il nome del Decoder
     * @param decoderPoints i punti del Decoder
     */

    public void showGameInfo(int gameID, String decoderName, int decoderPoints) {
        mainview.addTextInfo(gameID,decoderName,decoderPoints);
    }

    /**
     * Restituisce l'istanza di MainView.
     *
     * @return l'istanza di MainView
     */

    public MainView getMainView() {
        return mainview;
    }

    /**
     * Mostra un messaggio di vittoria con il numero di tentativi usati.
     *
     * @param attemptsUsed il numero di tentativi utilizzati per vincere
     */

    public void showVictoryMessage(int attemptsUsed) {
        mainview.victoryMessage(attemptsUsed);
    }

    /**
     * Mostra un messaggio di sconfitta con il codice segreto.
     *
     * @param secretCode il codice segreto
     */

    public void showLooseMessage(ArrayList<String> secretCode) {
        mainview.looseMessage(secretCode);
    }

    /**
     * Abilita il pulsante di controllo della sequenza.
     */

    public void enableSequenceCheckButton() {
        mainview.getCheckButton().setEnabled(true);
    }

    /**
     * Disabilita il pulsante di controllo della sequenza.
     */

    public void disableSequenceCheckButton() {
        mainview.getCheckButton().setEnabled(false);
    }

    /**
     * Controlla se non ci sono duplicati nella sequenza selezionata.
     *
     * @return true se non ci sono duplicati, false altrimenti
     */

    public boolean hasNoneSequenceDuplicates() {
        return mainview.checkDuplicateInSequence();
    }

    /**
     * Recupera la nuova sequenza selezionata dall'utente.
     *
     * @return un ArrayList di Color rappresentante la nuova sequenza
     */

    public ArrayList<Color> retrieveNewSequence() {
        ArrayList<Color> sequence = new ArrayList<>();
        for(ComboBox comboBox: mainview.getComboBoxes()) {
            sequence.add(Colors.values()[comboBox.getSelectedIndex()].getRgbColor());
        }
        return sequence;
    }

    /**
     * Mostra la nuova sequenza nella tabella degli tentativi.
     *
     * @param attempt il numero di tentativi
     * @param newSequence la nuova sequenza da mostrare
     */

    public void showNewSequence(int attempt, ArrayList<Color> newSequence) {
        for(int i = 0; i < newSequence.size(); i++) {
            mainview.getAttemptsTable().getModel().setCellColor(attempt, i + 1, newSequence.get(i));
        }
    }

    /**
     * Mostra un messaggio di errore se il nome inserito è vuoto.
     */

    public void showNameErrorNotValid() {
        decoderNameDialog.showErrorNameNotValid();
    }

    /**
     * Mostra un messaggio di errore se la difficoltà non è stata scelta.
     */

    public void showDifficultyErrorNotChosen() {
        mainview.difficultyError();
    }

    /**
     * Metodo di aggiornamento chiamato quando viene ricevuto un nuovo indizio.
     * Aggiorna la vista con il nuovo indizio.
     *
     * @param newHint il nuovo indizio
     * @param currentAttempt il tentativo corrente
     */

    @Override
    public void update(int[] newHint, int currentAttempt) {
        mainview.getAttemptsTable().getModel().setValueAt(newHint[0], currentAttempt, 0);
        mainview.getAttemptsTable().getModel().setValueAt(newHint[1], currentAttempt, 5);
        mainview.repaint();
    }

    /**
     * Metodo di aggiornamento chiamato quando vengono ricevuti nuovi punti.
     * Aggiorna la vista con le nuove informazioni del gioco.
     *
     * @param id l'ID del gioco
     * @param name il nome del Decoder
     * @param newPoints i nuovi punti del Decoder
     */

    @Override
    public void update(int id, String name, int newPoints) {
        mainview.addTextInfo(id, name, newPoints);
        mainview.repaint();
    }
}
