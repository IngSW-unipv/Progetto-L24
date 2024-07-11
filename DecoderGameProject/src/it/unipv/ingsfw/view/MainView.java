package it.unipv.ingsfw.view;


import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class MainView extends JFrame {

    private final JPanel choicePanel;
    private final JLabel infoLabel;
    private final OptionBar optionBar;
    private final AttemptsTable attemptsTable;
    private final ComboBox[] comboBoxes;
    private final CheckButton checkButton;
    private final String predefinedText = "Game N.  Decoder name:   Points: ";

    public MainView() {
        super("Decoding Game");
        setSize(800, 470);

        JPanel centerPanel = new JPanel();
        choicePanel = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());
        infoLabel = new JLabel(predefinedText, SwingConstants.CENTER);
        infoLabel.setFont(new Font("Inconsolata", Font.BOLD, 16));
        infoLabel.setVisible(false);
        optionBar = new OptionBar();
        optionBar.setEnabled(false);
        attemptsTable = new AttemptsTable(new AttemptsTableModel(0));
        attemptsTable.getTableHeader().setDefaultRenderer(new MainHeaderRenderer());
        attemptsTable.getTableHeader().getColumnModel()
                .getColumn(0).setHeaderRenderer(new wrongPosHeaderRenderer());
        attemptsTable.getTableHeader().getColumnModel()
                        .getColumn(5).setHeaderRenderer(new rightPosHeaderRenderer());
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

    public void addTextInfo(int gameID, String decoderName, int decoderPoints) {
        StringBuilder builder = new StringBuilder(predefinedText);
        builder.insert(7, gameID);
        builder.insert(24, decoderName);
        builder.append(decoderPoints);
        infoLabel.setText(builder.toString());
        infoLabel.setVisible(true);
    }

    public void defineVisibility(Boolean visible) {
        this.setVisible(visible);
    }

    public OptionBar getOptionBar() {
        return this.optionBar;
    }

    public AttemptsTable getAttemptsTable() {
        return this.attemptsTable;
    }

    public CheckButton getCheckButton() {
        return this.checkButton;
    }

    public ComboBox[] getComboBoxes() {
        return this.comboBoxes;
    }

    public void setupAttemptsTable(int attempts) {
        this.getAttemptsTable().setModel(new AttemptsTableModel(attempts));
        this.getAttemptsTable().getTableHeader().getColumnModel().
                getColumn(0).setHeaderRenderer(new graphics.wrongPosHeaderRenderer());
        this.getAttemptsTable().getTableHeader().getColumnModel().
                getColumn(5).setHeaderRenderer(new rightPosHeaderRenderer());
    }

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

    public void getColorList(String[] list) {
        for(int i = 0; i < comboBoxes.length; i++) {
            this.comboBoxes[i] = new ComboBox(list);
            this.choicePanel.add(comboBoxes[i]);
        }
    }
}
