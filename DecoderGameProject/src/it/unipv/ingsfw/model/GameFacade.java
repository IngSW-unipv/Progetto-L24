package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class GameFacade {

    private Encoder encoder;
    private Decoder decoder;
    private Game game;
    private int attemptsLeft;
    private final String[] colorList;

    public GameFacade() {
        colorList = new String[Colors.values().length];
        for(int i = 0; i < Colors.values().length; i++) {
            colorList[i] = Colors.values()[i].getColorName();
        }
        System.out.println("Model is ready!");
    }

    /*public void createGame(String decoderName, String encoderName,
                           EncoderStrategy strategy, Observer observer) {
        encoder = new Encoder(encoderName);
        encoder.setStrategy(strategy);
        encoder.addObserver(observer);

        decoder = new Decoder(decoderName);
        decoder.addObserver(observer);

        game = new Game();
    }

    public void createGame(String decoderName, EncoderStrategy strategy, Observer observer) {
        encoder = new Encoder();
        encoder.setStrategy(strategy);
        encoder.addObserver(observer);

        decoder = new Decoder(decoderName);
        decoder.addObserver(observer);

        game = new Game();
    }*/

    public void createNewEncoder(String encoderName, EncoderStrategy strategy, Observer observer) {
        this.encoder = new Encoder(encoderName);
        this.encoder.setStrategy(strategy);
        this.encoder.addObserver(observer);
    }

    public void createNewDecoder(String decoderName, Observer observer) {
        this.decoder = new Decoder(decoderName);
        this.decoder.addObserver(observer);
    }

    public void createNewGame(int id) {
        this.game = new Game();
        game.setId(id);
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    /*public void startGame() {
        encoder.generateSecretCode();
        game.start();
        System.out.println(game.getState());
        System.out.println(encoder.secretCodeToString().toString());
    }*/

    /*public int setDifficulty(String difficultyName) {
        game.defineTotalAttempts(difficultyName);
        initializeAttemptsLeft();
        game.initializeHints(game.getTotAttempts());
        return game.getTotAttempts();
    }*/

    /*public void endGame() {
        game.end();
    }*/

    public Encoder getEncoder() {
        return encoder;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    public Game getGame() {
        return game;
    }

    public String[] getColorList() {
        return colorList;
    }

    public void initializeAttemptsLeft() {
        this.attemptsLeft = game.getTotAttempts();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean hasAttemptsLeft() {
        return attemptsLeft > 0;
    }

    public int[] playTurn(ArrayList<Color> sequence) {
        this.game.addSequence(sequence);
        this.game.addHint(this.encoder.evaluateSequence(sequence));
        return this.game.getLastHint();
    }

    public void endTurn() {
        this.game.setCurrentAttempt(this.game.getCurrentAttempt() + 1);
        this.attemptsLeft -= 1;
    }

    public ArrayList<String> convertSecretCodeToString() {
        ArrayList<String> colorList = new ArrayList<>();
        for(Color color: encoder.getSecretCode()) {
            for(int i = 0; i < Colors.values().length; i++) {
                if(color.equals(Colors.values()[i].getRgbColor())) {
                    colorList.add(Colors.values()[i].getColorName());
                }
            }
        }
        return colorList;
    }
}
