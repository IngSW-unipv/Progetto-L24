package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

public class Encoder extends Player {

    private ArrayList<Color> secretCode;

    public Encoder(String name) {
        super(name);
        this.secretCode = new ArrayList<>();
    }

    public void GenerateSecretCode() {
//        algoritmo di generazione codice segreto
//        possibile adapter per generazione automatica/manuale
    }

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }

}
