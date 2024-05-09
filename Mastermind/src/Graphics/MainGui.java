package Graphics;

import Logic.CodeEvaluation;
import Logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainGui extends JFrame {

    Player player;
    int totAttempts = 0, attemptN = 0;
    int[] sequence, hints;
    AttemptTableModel attemptTableModel;
    OptionBar optionBar;
//    JPanel bottomPanel, centerPanel;
//    DropMenu dropMenu1;
//    DropMenu dropMenu2;
//    DropMenu dropMenu3;
//    DropMenu dropMenu4;
//    JButton button;

    public MainGui(int[] secretCode) {
        super("Mastermind");
        Dimension dimension = new Dimension(600, 300);
        setLayout(new BorderLayout());

        sequence = new int[4];
        hints = new int[2];

        String[] listaColori;
        listaColori = new String[Colors.values().length];
        for(int i = 0; i < listaColori.length;i++) {
            listaColori[i] = Colors.values()[i].getNomeColore();
        }

        AttemptsTablePanel attemptsTablePanel = new AttemptsTablePanel(totAttempts);
        optionBar = new OptionBar();
        JPanel choicePanel = new JPanel(new FlowLayout());
        ComboBox[] comboBoxes = new ComboBox[4];
        for (int i = 0; i < comboBoxes.length; i++) {
            comboBoxes[i] = new ComboBox(listaColori);
        }
        CheckButton checkButton = new CheckButton();

        for(ComboBox e: comboBoxes) {
            choicePanel.add(e);
        }
        attemptsTablePanel.add(choicePanel, BorderLayout.PAGE_END);

        add(optionBar, BorderLayout.PAGE_START);
        add(attemptsTablePanel, BorderLayout.CENTER);
        add(checkButton, BorderLayout.PAGE_END);

//        add(centerPanel, BorderLayout.CENTER);
//        centerPanel.add(attemptsTablePanel, BorderLayout.CENTER);
//        centerPanel.add(bottomPanel, BorderLayout.PAGE_END);
//        bottomPanel.add(dropMenu1);
//        bottomPanel.add(dropMenu2);
//        bottomPanel.add(dropMenu3);
//        bottomPanel.add(dropMenu4);
//        add(button, BorderLayout.PAGE_END);

        optionBar.setAttemptsListener(new AttemptsListener() {
            @Override
            public void difficultyChoose(int attempts) {
                totAttempts = attempts;
                player = new Player(totAttempts);
                attemptTableModel = new AttemptTableModel(totAttempts);
                attemptsTablePanel.attemptTable.setModel(attemptTableModel);
                attemptsTablePanel.attemptTable.getTableHeader().getColumnModel().getColumn(0)
                        .setHeaderRenderer(new RedKeyPolesHeaderRenderer());
                attemptsTablePanel.attemptTable.getTableHeader().getColumnModel().getColumn(5)
                        .setHeaderRenderer(new WhiteKeyPolesHeaderRenderer());
                attemptsTablePanel.updateUI();
            }
        });

        checkButton.addActionListener(e -> {

            if (totAttempts != 0) {
                if(attemptN < totAttempts) {

                    if (Stream.of(comboBoxes[1], comboBoxes[2], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[0].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[2], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[1].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[3]).noneMatch(comboBox -> comboBoxes[2].getSelectedIndex() == comboBox.getSelectedIndex())
                            && Stream.of(comboBoxes[0], comboBoxes[1], comboBoxes[2]).noneMatch(comboBox -> comboBoxes[3].getSelectedIndex() == comboBox.getSelectedIndex())) {

                        for(int i = 0; i < sequence.length;i++) {
                            sequence[i] = comboBoxes[i].getSelectedIndex();
                            attemptTableModel.setCellColor(attemptN,i+1,Colors.values()[sequence[i]].getColoreRGB());
                        }
                        player.setSequence(attemptN, sequence);

                        System.arraycopy(CodeEvaluation.codeConfront(secretCode, sequence), 0, hints, 0, 2);
                        System.out.println("indizi: " + hints[1] + " " + hints[0]);

//                        leftTablePanel.table.getModel().setValueAt(hints[1], attemptN, 0);
//                        rightTablePanel.table.getModel().setValueAt(hints[0], attemptN, 0);

                        attemptTableModel.setHints(attemptN,0,hints[1]);
                        attemptTableModel.setHints(attemptN,5,hints[0]);


                        attemptN += 1;

                        if (hints[1] == 4) {
                            attemptsTablePanel.attemptTable.endLine.add("Congratulazioni! Hai indovinato il codice segreto");
                            attemptsTablePanel.attemptTable.endLine.setSize(attemptsTablePanel.attemptTable.endLine.getPreferredSize());
                            attemptsTablePanel.attemptTable.endLine.setLocation(this.getLocation());
                            attemptsTablePanel.attemptTable.endLine.setVisible(true);
                        }
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

        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}
