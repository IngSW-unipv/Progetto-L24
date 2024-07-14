package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Implementazione dell'interfaccia EncoderStrategy che rappresenta un encoder manuale.
 * L' encoder manuale utilizza un codice segreto definito dall'utente durante l'inizializzazione.
 */

public class ManualEncoder implements EncoderStrategy {

    private final ArrayList<Color> secretCode;

    /**
     * Costruttore che inizializza l' encoder manuale con un codice segreto specificato.
     *
     * @param secretCode l' arraylist di colori che rappresenta il codice segreto da utilizzare.
     */

    public ManualEncoder(ArrayList<Color> secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Metodo per la definizione di un nuovo codice segreto.
     */

    @Override
    public void generateSecretCode() {

    }

    /**
     * Inserisce il codice segreto definito tramite la lista passata
     * come parametro.
     *
     * @param secretCode la lista di valori da inserire nel codice segreto.
     */

    @Override
    public void setSecretCode(ArrayList<Color> secretCode) {
        this.secretCode.clear();
        this.secretCode.addAll(secretCode);
    }

    /**
     * Metodo per la valutazione di una sequenza tentata dal Decoder e la restituzione
     * del suggerimento generato.
     *
     * @param attemptSequence la sequenza di colori tentata dal Decoder.
     * @return un array di int che rappresenta il suggerimento per la sequenza tentata.
     */

    @Override
    public int[] evaluateSequence(ArrayList<Color> attemptSequence) {
        return new int[0];
    }

    /**
     * Restituisce il codice segreto utilizzato dall' encoder manuale.
     *
     * @return l'arraylist di colori che rappresenta il codice segreto.
     */

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }
}
