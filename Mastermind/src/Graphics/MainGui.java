package Graphics;

import Logic.CodeEvaluation;
import Logic.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.stream.Stream;

public class MainGui extends JFrame {

    int totAttempts = 0, attemptN = 0;
    int[] sequence, hints;
    Player player;
    AttemptTableModel attemptTableModel;

    public MainGui(int[] secretCode) {
        super("Mastermind");
        Dimension dimension = new Dimension(600, 300);
        setPreferredSize(dimension);
        setLayout(new BorderLayout());

        sequence = new int[4];
        hints = new int[2];

        String[] listaColori;
        listaColori = new String[Colors.values().length];
        for(int i = 0; i < listaColori.length;i++) {
            listaColori[i] = Colors.values()[i].getNomeColore();
        }
//        Inizializzazioni:

//        Barra menu
        OptionBar optionBar = new OptionBar();
//        Pannello centrale per la tabella
        AttemptsTablePanel attemptsTablePanel = new AttemptsTablePanel(totAttempts);
//        Pannello per i menu a tendina
        JPanel choicePanel = new JPanel(new FlowLayout());
//        Menu a tendina per la scelta dei colori
        ComboBox[] comboBoxes = new ComboBox[4];
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

        optionBar.setAttemptsListener(new AttemptsListener() {
            @Override
            public void difficultyChoose(int attempts) {

//                definizione thread+++++++++++++++++++

//                Inizializzazioni:

//                Nuovo valore per numero totale tentativi
                totAttempts = attempts;
//                Giocatore dopo conferma impostazioni
                player = new Player(totAttempts);
//                Nuovo modello tabella per aggiornamento righe
                attemptTableModel = new AttemptTableModel(totAttempts);
//                Applicazione modello alla tabella
                attemptsTablePanel.attemptTable.setModel(attemptTableModel);
//                Aggiornamenti grafici Headers
                attemptsTablePanel.attemptTable.getTableHeader().getColumnModel().getColumn(0)
                        .setHeaderRenderer(new wrongPosHeaderRenderer());
                attemptsTablePanel.attemptTable.getTableHeader().getColumnModel().getColumn(5)
                        .setHeaderRenderer(new rightPosHeaderRenderer());
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

                    if (Stream.of(comboBoxes[1], comboBoxes[2], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[0].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[2], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[1].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[2].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[2]).noneMatch(comboBox -> comboBoxes[3].getSelectedIndex() == comboBox.getSelectedIndex())) {

//                        Ciclo per salvataggio sequenza colori

                        for(int i = 0; i < sequence.length;i++) {
                            sequence[i] = comboBoxes[i].getSelectedIndex();
//                            Visualizzazione colori nella tabella
                            attemptTableModel.setCellColor(attemptN,i+1,Colors.values()[sequence[i]].getColoreRGB());
                        }
//                        Salvataggio sequenza tra informazioni giocatore
                        player.setSequence(attemptN, sequence);
//                        Verifica tentativo
                        System.arraycopy(CodeEvaluation.codeConfront(secretCode, sequence), 0, hints, 0, 2);
//                        Console check
                        System.out.println("indizi: " + hints[0] + " " + hints[1]);
//                        Inserimento indizi in tabella

                        attemptsTablePanel.attemptTable.getModel().setValueAt(hints[0], attemptN, 0);
                        attemptsTablePanel.attemptTable.getModel().setValueAt(hints[1], attemptN, 5);

//                        Incremento tentativo odierno
                        attemptN += 1;

//                        Azioni in caso di vittoria

                        if (hints[1] == 4) {
                            attemptsTablePanel.attemptTable.endLine.add("Congratulazioni! Hai indovinato il codice segreto");
                            attemptsTablePanel.attemptTable.endLine.setSize(attemptsTablePanel.attemptTable.endLine.getPreferredSize());
                            attemptsTablePanel.attemptTable.endLine.setLocation(this.getLocation());
                            attemptsTablePanel.attemptTable.endLine.setVisible(true);
                        }

//                        Azioni in caso di sconfitta

                        if (attemptN == totAttempts && hints[1] != 4) {
                            attemptsTablePanel.attemptTable.endLine.add("Peccato! Hai terminato i tentativi. Il codice corretto è: " +
                                    Colors.values()[secretCode[0]].getNomeColore() + ", " + Colors.values()[secretCode[1]].getNomeColore() +
                                    ", " + Colors.values()[secretCode[2]].getNomeColore() + ", " + Colors.values()[secretCode[3]].getNomeColore());
                            attemptsTablePanel.attemptTable.endLine.setSize(attemptsTablePanel.attemptTable.endLine.getPreferredSize());
                            attemptsTablePanel.attemptTable.endLine.setLocation(this.getLocation());
                            attemptsTablePanel.attemptTable.endLine.setVisible(true);
                        }
                    }
                }
            }

        });

//        Impostazioni finestra

        setSize(getPreferredSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}
