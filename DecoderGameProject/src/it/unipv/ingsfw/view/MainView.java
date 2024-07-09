package it.unipv.ingsfw.view;

import it.unipv.ingsfw.model.Colors;
import it.unipv.ingsfw.model.Observer;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame implements Observer {

    private JPanel centerPanel;
    private JLabel infoLabel;
    private OptionBar optionBar;
    private AttemptsTable attemptsTable;
    private ComboBox[] comboBoxes;
    private CheckButton checkButton;
    private String predefinedText = "Game N.  Decoder name:   Points: ";
    private int gameID;
    private String decoderName;
    private int decoderPoints;
    private String[] colorList;

    public MainView() {
        super("Decoding Game");
        setSize(800, 470);

        centerPanel = new JPanel();
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
        centerPanel.add(new JPanel(new FlowLayout()), BorderLayout.PAGE_END);
        add(optionBar, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(checkButton, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addTextInfo(int gameID, String decoderName, int decoderPoints) {
        this.gameID = gameID;
        this.decoderName = decoderName;
        this.decoderPoints = decoderPoints;
        update();
    }

    public void defineVisibility(Boolean visible) {
        this.setVisible(visible);
    }

    public OptionBar getOptionBar() {
        return this.optionBar;
    }

    public void getColorList(String[] list) {
        this.colorList = list;
        for(int i = 0; i < comboBoxes.length; i++) {
            this.comboBoxes[i] = new ComboBox(list);
        }
    }

    @Override
    public void update() {
        StringBuilder builder = new StringBuilder(predefinedText);
        builder.insert(7, gameID);
        builder.insert(24, decoderName);
        builder.append(decoderPoints);
        infoLabel.setText(builder.toString());
        infoLabel.setVisible(true);
    }
}