package it.unipv.ingsfw.model;

import graphics.Colors;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AutoEncoder implements EncoderStrategy {

    private ArrayList<Color> secretCode;

    public AutoEncoder() {
        this.secretCode = new ArrayList<>();
    }

    @Override
    public void generateSecretCode() {
        Random random = new Random();
        Color color;
        for(int i = 0; i < 4; i++) {
            do {
                color = graphics.Colors.values()[random.nextInt(Colors.values().length)].getColoreRGB();
            } while (secretCode.contains(color));
            secretCode.add(color);
        }
    }

    @Override
    public int[] evaluateSequence(ArrayList<Color> attemptSequence) {
        if (attemptSequence != null && secretCode != null) {
            int[] hint = new int[2];
            for(int i = 0; i < attemptSequence.size(); i++) {
                if(attemptSequence.get(i).equals(secretCode.get(i))) {
                    hint[1] += 1;
                }
                else {
                    for(int j = 0; j < attemptSequence.size(); j++) {
                        if(j != i && attemptSequence.get(i).equals(secretCode.get(j))) {
                            hint[0] += 1;
                        }
                    }
                }
            }
            return hint;
        }
        else {
            throw new RuntimeException("Secret code or sequence given not valid");
        }
    }

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }
}
