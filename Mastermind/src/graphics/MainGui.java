package graphics;   //Definisce il package in cui si trova la classe MainGui
//importazioni utili alla corretta definizione di aspetti grafici, informazioni su altre classi
//e operazioni sequenziali
import logic.CodeEvaluation;
import logic.Player;
import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

/**
 * Interfaccia generale del gioco.
 */
public class MainGui extends JFrame {
//    Definizioni:

    /**
     * Numero totale tentativi e tentativo corrente.
     */
    int totAttempts = 0, attemptN = 0;
    /**
     * Sequenza di colori del tentativo corrente.
     */
    int[] sequence;
    /**
     * Giocatore della partita.
     */
    Player player;
    /**
     * Sistema di valutazione delle sequenze inserite dal giocatore.
     */
    CodeEvaluation codeEvaluation;
    /**
     * Modello specifico per la tabella di gioco.
     */
    AttemptTableModel attemptTableModel;
//    Costruttore:

    /**
     * Definizione delle proprietà grafiche dell'interfaccia delle operazioni di collegamento con i sotto-componenti.
     * @param secretCode
     * Codice segreto della partita che il giocatore deve individuare.
     */
    public MainGui(int[] secretCode) {
//        inserimento titolo finestra
        super("Mastermind");
//        definizione dimensioni
        Dimension dimension = new Dimension(800, 470);
        setPreferredSize(dimension);
//        definizione layout finestra
        setLayout(new BorderLayout());
//        definizione lista totale colori
        final String[] listaColori;
//        inizializzazione lista colori
        listaColori = new String[Colors.values().length];
//        inserimento stringhe provenienti da enum Colors
        for(int i = 0; i < listaColori.length;i++) {
            listaColori[i] = Colors.values()[i].getNomeColore();
        }
//        Inizializzazioni:

        sequence = new int[4];
//        Dichiarazioni interne:

//        Barra menu
        OptionBar optionBar = new OptionBar();
//        Pannello centrale per la tabella
        AttemptsTablePanel attemptsTablePanel = new AttemptsTablePanel(totAttempts);
//        Pannello per i menu a tendina
        JPanel choicePanel = new JPanel(new FlowLayout());
//        Menu a tendina per la scelta dei colori
        ComboBox[] comboBoxes = new ComboBox[4];
//        inserimento stringhe lista colori nei menu a tendina
        for (int i = 0; i < comboBoxes.length; i++) {
            comboBoxes[i] = new ComboBox(listaColori);
        }
//        Bottone per la conferma dei colori
        CheckButton checkButton = new CheckButton();


//        Inserimenti:

//        4 menu nel relativo pannello
        for(ComboBox e: comboBoxes) {
            choicePanel.add(e);
        }
//        Pannello menu nel pannello centrale
        attemptsTablePanel.add(choicePanel, BorderLayout.PAGE_END);
//        Barra menu in alto nella finestra
        add(optionBar, BorderLayout.PAGE_START);
//        Pannello centrale nella finestra
        add(attemptsTablePanel, BorderLayout.CENTER);
//        Bottone sul fondo della finestra
        add(checkButton, BorderLayout.PAGE_END);

//        Listener per la scelta delle impostazioni di gioco

        //noinspection Convert2Lambda
        optionBar.setAttemptsListener(new AttemptsListener() {
            @Override
            public void difficultyChoose(int attempts) {

//                Inizializzazioni:

//                Nuovo valore per numero totale tentativi
                totAttempts = attempts;
//                Giocatore dopo conferma impostazioni
                player = new Player(totAttempts);
//                Nuovo modello tabella per aggiornamento righe
                attemptTableModel = new AttemptTableModel(totAttempts);
//                Applicazione modello alla tabella
                attemptsTablePanel.getAttemptTable().setModel(attemptTableModel);
//                Aggiornamenti grafici Headers
                attemptsTablePanel.getAttemptTable().getTableHeader().getColumnModel().getColumn(0)
                        .setHeaderRenderer(new wrongPosHeaderRenderer());
                attemptsTablePanel.getAttemptTable().getTableHeader().getColumnModel().getColumn(5)
                        .setHeaderRenderer(new rightPosHeaderRenderer());
//                impostazione visibilità popup per eventuale nuovo gioco
                attemptsTablePanel.getAttemptTable().popup.setVisible(false);
                attemptsTablePanel.updateUI();
            }
        });

//        Azioni alla pressione del tasto di conferma

        checkButton.addActionListener(e -> {

//            Blocco pulsante fino a scelta difficoltà

            if (totAttempts != 0) {

//                Verifica tentativo valido

                if(attemptN < totAttempts) {

//                    Blocco pulsante se colori duplicati

                    if (Stream.of(comboBoxes[1], comboBoxes[2], comboBoxes[3]).
                            noneMatch(comboBox -> comboBoxes[0].
                                    getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[2], comboBoxes[3]).
                            noneMatch(comboBox -> comboBoxes[1].
                                    getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[3]).
                            noneMatch(comboBox -> comboBoxes[2].
                                    getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[2]).
                            noneMatch(comboBox -> comboBoxes[3].
                                    getSelectedIndex() == comboBox.getSelectedIndex())) {

//                        Ciclo di salvataggio sequenza colori

                        for(int i = 0; i < sequence.length;i++) {
                            sequence[i] = comboBoxes[i].getSelectedIndex();
//                            Visualizzazione colori nella tabella
                            attemptTableModel.setCellColor(attemptN,i+1,Colors.
                                    values()[sequence[i]].getColoreRGB());
                        }
//                        Salvataggio sequenza tentativo in informazioni giocatore
                        player.setSequence(attemptN, sequence);
//                        Preparativi inizio thread di controllo sequenza:

//                        nuova istanza di verifica per tentativo corrente
                        codeEvaluation = new CodeEvaluation();
//                        inserimento codice segreto
                        codeEvaluation.setCode(secretCode);
//                        inserimento sequenza tentativo corrente
                        codeEvaluation.setGuess(sequence);
//                        inizio thread di verifica
                        codeEvaluation.start();
//                        attesa fine operazioni di verifica ed eventuale eccezione
                        try {
                            codeEvaluation.join();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
//                        Inserimento indizi in tabella
                        attemptsTablePanel.getAttemptTable().getModel().
                                setValueAt(codeEvaluation.getHints()[0], attemptN, 0);
                        attemptsTablePanel.getAttemptTable().getModel().
                                setValueAt(codeEvaluation.getHints()[1], attemptN, 5);
//                        Incremento tentativo odierno
                        attemptN += 1;

//                        Azioni in caso di vittoria

                        if (codeEvaluation.getHints()[1] == 4) {
//                            visualizzazione popup vittoria
                            attemptsTablePanel.getAttemptTable().popup.setVictoryMessage(attemptN);
                        }

//                        Azioni in caso di sconfitta

                        if (attemptN == totAttempts && codeEvaluation.getHints()[1] != 4) {
//                            visualizzazione popup sconfitta con codice segreto
                            attemptsTablePanel.getAttemptTable().popup.setLooseMessage(secretCode);
                        }
                    }
                }
            }

        });
//        Impostazioni:

//        dimensione finestra
        setSize(getPreferredSize());
//        posizione finestra
        setLocationRelativeTo(null);
//        terminazione programma alla chiusura finestra
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        visibilità
        setVisible(true);
    }
}
