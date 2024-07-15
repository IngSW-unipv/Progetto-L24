package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.awt.Color;

/**
 * Classe Singleton per la gestione delle sequenze di colori nel gioco.
 * Conserva e fornisce accesso alle sequenze di colori memorizzate.
 */

public class SequencesStorage {

    private static SequencesStorage instance;
    private final ArrayList<ArrayList<Color>> sequences;

    /**
     * Costruttore privato che inizializza l'istanza e la lista delle sequenze.
     */

    private SequencesStorage() {
        sequences = new ArrayList<>();
    }

    /**
     * Metodo statico per ottenere l'istanza Singleton di SequencesStorage.
     *
     * @return l'istanza Singleton di SequencesStorage.
     */

    public static SequencesStorage getInstance() {
        if(instance == null) {
            instance = new SequencesStorage();
        }
        return instance;
    }

    /**
     * Aggiunge una nuova sequenza di colori alla lista delle sequenze memorizzate.
     *
     * @param sequence la sequenza di colori da aggiungere.
     */

    public void addSequence(ArrayList<Color> sequence) {
        sequences.add(sequence);
    }

    /**
     * Restituisce tutte le sequenze di colori memorizzate.
     *
     * @return un ArrayList contenente tutte le sequenze di colori memorizzate.
     */

    public ArrayList<ArrayList<Color>> getSequences() {
        return sequences;
    }
}
