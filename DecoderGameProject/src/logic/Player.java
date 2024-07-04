package logic;  //Definisce il Package in cui è contenuta la classe Player

/**
 * Giocatore della partita.
 */
public class Player {

//    Definizioni:

    /**
     * Numero totale di tentativi a disposizione.
     */
    public int attempts;
    /**
     * Matrice delle sequenze di colori inserite dal giocatore.
     */
    private final int[][] sequences;

//    Costruttore:

    /**
     * Definizione delle caratteristiche del giocatore.
     * @param attempts
     * Numero totale di tentativi disponibili.
     */
    public Player(int attempts) {

//        Inizializzazioni:

        this.attempts = attempts;
        sequences = new int[attempts][4];
    }

    /**
     * Impostazione nuova sequenza di colori scelta dal giocatore nel tentativo attuale.
     * @param tryN
     * Numero del tentativo corrente.
     * @param sequence
     * Sequenza di colori scelta.
     */
    public void setSequence(int tryN, int[] sequence) {
        System.arraycopy(sequence, 0, sequences[tryN], 0, sequence.length);
    }

    /**
     * Acquisizione di una sequenza di colori dalla matrice.
     * @param tryN
     * Numero della sequenza da estrarre dalla matrice [numero della riga / tentativo].
     * @return
     * Sequenza estratta.
     */
    @SuppressWarnings("unused")
    public int[] getSequence(int tryN) {

        return sequences[tryN];
    }

    /**
     * Acquisizione della matrice dei colori scelti dal giocatore.
     * @return
     * Matrice dei colori.
     */
    public int[][] getSequences() {

        return sequences;
    }
}
