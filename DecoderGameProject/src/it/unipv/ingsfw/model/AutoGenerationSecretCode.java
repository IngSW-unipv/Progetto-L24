package it.unipv.ingsfw.model;

import graphics.Colors;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class AutoGenerationSecretCode implements SecretCodeStrategy {

    @Override
    public ArrayList<Color> generateSecretCode() {
        ArrayList<Color> secretCode = new ArrayList<>();
        Random random = new Random();
        Color color;
        for(int i = 0; i < 4; i++) {
            do {
                color = Colors.values()[random.nextInt(Colors.values().length)].getColoreRGB();
            } while (secretCode.contains(color));
            secretCode.add(color);
        }
        return secretCode;
    }
}
