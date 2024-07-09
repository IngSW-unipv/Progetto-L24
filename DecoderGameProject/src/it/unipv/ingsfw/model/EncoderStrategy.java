package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.awt.Color;

public interface EncoderStrategy {

    void generateSecretCode();

    int[] evaluateSequence(ArrayList<Color> attemptSequence);

    ArrayList<Color> getSecretCode();

}
