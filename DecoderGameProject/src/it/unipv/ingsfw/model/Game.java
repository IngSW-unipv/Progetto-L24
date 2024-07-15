package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.awt.Color;

/**
 * Classe che rappresenta una partita del gioco.
 * Gestisce l'id della partita, il numero totale di tentativi, i tentativi effettuati,
 * lo stato della partita, le sequenze di tentativi e i suggerimenti forniti.
 */

public class Game{

    private int id; //  Identificativo univoco della partita
    private int totAttempts; // Rappresenta il numero totale di tentativi della partita
    private int attemptPlayed; //   Rappresenta il numero di tentativi gia eseguiti per la partita
    private String state; //    Definisce lo stato della partita
    private final SequencesStorage sequencesStorage; // Gestore delle sequenze della partita
    private final HintsStorage hintsStorage; // Gestore dei suggerimenti della partita

    /**
     * Costruttore della classe Game.
     * Inizializza i gestori delle sequenze di tentativi e dei suggerimenti.
     * Imposta il numero totale di tentativi a 0, i tentativi effettuati a 0
     * e lo stato della partita a "Not started".
     */

    public Game() {
        sequencesStorage = SequencesStorage.getInstance();
        hintsStorage = HintsStorage.getInstance();
        this.totAttempts = 0;
        this.attemptPlayed = 0;
        this.state = "Not started";
    }

    /**
     * Avvia la partita impostando lo stato a "Started".
     */

    public void start() {
        this.state = "Started";
    }

    /**
     * Termina la partita impostando lo stato a "Ended".
     */

    public void end() {
        this.state = "Ended";
    }

    /**
     * Imposta l'ID della partita.
     *
     * @param id l'ID della partita.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce l'ID della partita.
     *
     * @return l'ID della partita.
     */

    public int getId() {
        return id;
    }

    /**
     * Restituisce lo stato corrente della partita.
     *
     * @return lo stato corrente della partita ("Not started", "Started", "Ended").
     */

    public String getState() {
        return state;
    }

    /**
     * Aggiunge una nuova sequenza di tentativo alla partita.
     *
     * @param sequence la sequenza di colori del tentativo.
     */

    public void addSequence(ArrayList<Color> sequence) {
        sequencesStorage.addSequence(sequence);
    }

    /**
     * Restituisce tutte le sequenze di tentativi effettuate nella partita.
     *
     * @return lista di tutte le sequenze di tentativi.
     */

    public ArrayList<ArrayList<Color>> getSequences() {
        return sequencesStorage.getSequences();
    }

    /**
     * Definisce il numero totale di tentativi basato sulla difficoltà selezionata.
     *
     * @param difficultyName nome della difficoltà selezionata.
     */

    public void defineTotalAttempts(String difficultyName) {
        for(int i = 0; i < Difficulty.values().length; i++) {
            if(Difficulty.values()[i].toString().equals(difficultyName)) {
                this.totAttempts = Difficulty.values()[i].getAttempts();
            }
        }
    }

    /**
     * Restituisce il numero totale di tentativi disponibili per la partita.
     *
     * @return numero totale di tentativi.
     */

    public int getTotAttempts() {
        return totAttempts;
    }

    /**
     * Imposta il numero di tentativi effettuati nella partita.
     *
     * @param attemptPlayed numero di tentativi effettuati.
     */

    public void setAttemptPlayed(int attemptPlayed) {
        this.attemptPlayed = attemptPlayed;
    }

    /**
     * Restituisce il numero di tentativi effettuati nella partita.
     *
     * @return numero di tentativi effettuati.
     */

    public int getAttemptPlayed() {
        return attemptPlayed;
    }

    /**
     * Inizializza i suggerimenti per la partita, basandosi sul numero di tentativi.
     *
     * @param attempts numero di tentativi per la partita.
     */

    public void initializeHints(int attempts) {
        hintsStorage.initializeHints(attempts);
    }

    /**
     * Aggiunge un suggerimento alla lista di suggerimenti per la partita.
     *
     * @param hint array che rappresenta il suggerimento da aggiungere.
     */

    public void addHint(int[] hint) {
        hintsStorage.addHint(this.attemptPlayed, hint);
    }

    /**
     * Restituisce l'ultimo suggerimento aggiunto alla partita.
     *
     * @return array che rappresenta l'ultimo suggerimento aggiunto.
     */

    public int[] getLastHint() {
        return this.hintsStorage.getLastHint();
    }
}
