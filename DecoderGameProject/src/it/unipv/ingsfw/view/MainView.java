package it.unipv.ingsfw.view;

import it.unipv.ingsfw.model.Observer;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame implements Observer {

    private JPanel centerPanel;
    private JLabel infoLabel;
    private String predefinedText = "Game N.  Decoder name:   Points: ";
    private int gameID;
    private String decoderName;
    private int decoderPoints;

    public MainView() {
        super("Decoding Game");
        setSize(800, 470);
        centerPanel = new JPanel();
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());
        infoLabel = new JLabel(predefinedText, SwingConstants.CENTER);
        infoLabel.setFont(new Font("Inconsolata", Font.BOLD, 16));
        infoLabel.setVisible(false);
        centerPanel.add(infoLabel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
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
