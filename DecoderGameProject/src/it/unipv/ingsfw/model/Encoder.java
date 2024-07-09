package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class Encoder extends Player {

    private EncoderStrategy strategy;

    public Encoder() {
        super("CPU");
    }

    public Encoder(String name) {
        super(name);
    }

    public void setStrategy(EncoderStrategy strategy) {
        this.strategy = strategy;
    }

    public void generateSecretCode() {
        if(strategy != null) {
            strategy.generateSecretCode();
            notifyObservers();
        }
    }

    public int[] evaluateSequence(ArrayList<Color> sequence) {
        return strategy.evaluateSequence(sequence);
    }

    public ArrayList<Color> getSecretCode() {
        return strategy.getSecretCode();
    }

}
