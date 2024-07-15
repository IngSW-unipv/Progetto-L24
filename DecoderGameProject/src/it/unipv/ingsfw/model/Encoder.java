package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe che rappresenta un giocatore di tipo Encoder.
 * Estende la classe astratta Player e rappresenta un giocatore che
 * genera un codice segreto e valuta le sequenze di tentativi.
 */

public class Encoder extends Player {

    private static Encoder instance;
    private EncoderStrategy strategy;

    /**
     * Costruttore privato di un Encoder con il nome specificato.
     *
     * @param name nome dell' encoder.
     */

    private Encoder(String name) {
        super(name);
    }

    /**
     * Restituisce l'istanza singleton di Encoder.
     *
     * @param name il nome da applicare all' Encoder.
     * @return l'istanza singleton dell' Encoder.
     */

    public static Encoder getInstance(String name) {
        if(instance == null) {
            instance = new Encoder(name);
        }
        return instance;
    }

    /**
     * Imposta la strategia da utilizzare per l' encoder.
     *
     * @param strategy strategia da impostare.
     */

    public void setStrategy(EncoderStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Acquisisce la strategia applicata all' Encoder.
     *
     * @return la strategia dell' Encoder.
     */

    public EncoderStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Genera il codice segreto utilizzando la strategia impostata.
     * Se la strategia non è impostata (null), non fa nulla.
     */

    public void generateSecretCode() {
        if(strategy != null) {
            strategy.generateSecretCode();
        }
    }

    /**
     * Inserisce il codice segreto definito tramite la lista passata
     * come parametro.
     *
     * @param secretCode la lista di valori da inserire nel codice segreto.
     */

    public void setSecretCode(ArrayList<Color> secretCode) {
        this.strategy.setSecretCode(secretCode);
    }

    /**
     * Ottiene il codice segreto generato dalla strategia impostata.
     * Se la strategia non è impostata (null), ritorna null.
     *
     * @return lista di colori che rappresenta il codice segreto.
     */

    public ArrayList<Color> getSecretCode() {
        if(strategy != null) {
            return strategy.getSecretCode();
        }
        return null;
    }

    /**
     * Valuta una sequenza di tentativo rispetto al codice segreto utilizzando la strategia impostata.
     * Se la strategia non è impostata (null), ritorna null.
     *
     * @param sequence sequenza di colori da valutare.
     * @return array di interi contenente l'esito della valutazione della sequenza.
     */

    public int[] evaluateSequence(ArrayList<Color> sequence) {
        if(strategy != null) {
            return strategy.evaluateSequence(sequence);
        }
        return null;
    }

    /**
     * Esegue il reset dell' istanza singleton dell' Encoder.
     */

    public static void resetInstance() {
        instance = null;
    }

}
