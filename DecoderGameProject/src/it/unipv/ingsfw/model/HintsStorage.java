package it.unipv.ingsfw.model;

/**
 * Questa classe gestisce lo storage dei suggerimenti associati ai tentativi di gioco.
 * Utilizza un array bidimensionale per memorizzare i suggerimenti per ciascun tentativo.
 */

public class HintsStorage {

    private static HintsStorage instance;
    private int[][] hints;

    /**
     * Costruttore privato per inizializzare una singola istanza di HintsStorage.
     */

    private HintsStorage() {
    }

    /**
     * Restituisce l'istanza singleton di HintsStorage.
     *
     * @return l'istanza singleton di HintsStorage.
     */

    public static HintsStorage getInstance() {
        if(instance == null) {
            instance = new HintsStorage();
        }
        return instance;
    }

    /**
     * Inizializza lo storage dei suggerimenti con la dimensione specificata.
     *
     * @param attempts il numero di tentativi per cui allocare lo spazio di memoria per i suggerimenti.
     */

    public void initializeHints(int attempts) {
        this.hints = new int[attempts][];
    }

    /**
     * Aggiunge un suggerimento per un tentativo specifico.
     *
     * @param attempt l'indice del tentativo a cui aggiungere il suggerimento.
     * @param hint l' array di interi che rappresenta il suggerimento da aggiungere.
     */

    public void addHint(int attempt, int[] hint) {
        hints[attempt] = hint;
    }

    /**
     * Restituisce l'ultimo suggerimento registrato, ovvero il suggerimento dell'ultimo tentativo effettuato.
     *
     * @return l'array di interi che rappresenta l'ultimo suggerimento registrato, o null se non ci sono suggerimenti registrati.
     */

    public int[] getLastHint() {
        if(hints == null || hints.length == 0) {
            return null;
        }

        for(int i = hints.length - 1; i >= 0; i--) {
            if(hints[i] != null) {
                return hints[i];
            }
        }
        return null;
    }

}
