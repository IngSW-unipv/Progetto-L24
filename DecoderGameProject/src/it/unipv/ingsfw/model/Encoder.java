package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class Encoder extends Player {

    private ArrayList<Color> secretCode;
    private SecretCodeStrategy strategy;

    public Encoder() {
        super("CPU");
        this.secretCode = new ArrayList<>();
    }

    public Encoder(String name) {
        super(name);
        this.secretCode = new ArrayList<>();
    }

    public void setSecretCodeStrategy(SecretCodeStrategy strategy) {
        this.strategy = strategy;
    }

    public void generateSecretCode() {
        if(strategy != null) {
            this.secretCode = strategy.generateSecretCode();
            notifyObservers();
        }
    }

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }

}
