package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.awt.Color;

public class Game {

    private int id;
    private String state;
    private ArrayList<ArrayList<Color>> sequences;
    private int totAttempts, currentAttempt;
    private int[][] hints;

    public Game() {
        sequences = new ArrayList<>();
        this.totAttempts = 0;
        this.state = "Not started";
    }

    public void start() {
        this.state = "started";
    }

    public void end() {
        this.state = "ended";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void addSequence(ArrayList<Color> sequence) {
        sequences.add(sequence);
    }

    public ArrayList<ArrayList<Color>> getSequences() {
        return sequences;
    }

    public void defineTotalAttempts(String difficultyName) {
        for(int i = 0; i < Difficulty.values().length; i++) {
            if(Difficulty.values()[i].toString().equals(difficultyName)) {
                this.totAttempts = Difficulty.values()[i].getAttempts();
            }
        }
    }

    public int getTotAttempts() {
        return totAttempts;
    }

    public void setCurrentAttempt(int currentAttempt) {
        this.currentAttempt = currentAttempt;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void initializeHints(int attempts) {
        this.hints = new int[attempts][];
    }

    public void addHint(int[] hint) {
        hints[currentAttempt] = hint;
    }

    public int[] getLastHint() {
        return this.hints[this.currentAttempt];
    }
}
