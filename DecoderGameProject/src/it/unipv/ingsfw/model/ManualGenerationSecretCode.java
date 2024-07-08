package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class ManualGenerationSecretCode implements SecretCodeStrategy {

    private ArrayList<Color> secretCode;

    public ManualGenerationSecretCode(ArrayList<Color> secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public ArrayList<Color> generateSecretCode() {
        return new ArrayList<>(secretCode);
    }
}
