package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class ManualEncoder implements EncoderStrategy {

    private final ArrayList<Color> secretCode;

    public ManualEncoder(ArrayList<Color> secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public void generateSecretCode() {
//        Code for manual definition of secretCode
    }

    @Override
    public int[] evaluateSequence(ArrayList<Color> attemptSequence) {
//        code for manual evaluation of a sequence and definition of attempt hint
        return new int[0];
    }

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }
}
