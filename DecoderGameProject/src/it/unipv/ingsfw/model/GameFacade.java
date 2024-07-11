package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class GameFacade {

    private Encoder encoder;
    private Decoder decoder;
    private Game game;
    private int attemptsLeft;
    private final String[] colorList;
    private final GameEntitiesFactory factory;

    public GameFacade() {
        this.factory = new ConcreteGameEntitiesFactory();
        colorList = new String[Colors.values().length];
        for(int i = 0; i < Colors.values().length; i++) {
            colorList[i] = Colors.values()[i].getColorName();
        }
        System.out.println("Model is ready!");
    }

    public void createNewEncoder(String encoderName, EncoderStrategy strategy, Observer observer) {
        this.encoder = factory.createEncoder(encoderName);
        this.encoder.setStrategy(strategy);
        this.encoder.addObserver(observer);
    }

    public void createNewDecoder(String decoderName, Observer observer) {
        this.decoder = factory.createDecoder(decoderName);
        this.decoder.addObserver(observer);
    }

    public void createNewGame(int id) {
        this.game = factory.createGame();
        game.setId(id);
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

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

    public void playTurn(ArrayList<Color> sequence) {
        this.game.addSequence(sequence);
        int[] hint = this.encoder.evaluateSequence(sequence);
        this.game.addHint(hint);
        this.encoder.notifyObservers(hint, this.game.getCurrentAttempt());
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
