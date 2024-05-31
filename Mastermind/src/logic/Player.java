package logic;  //Definisce il Package in cui è contenuta la classe Player

public class Player {

//    Definizioni:

//    tentativi totali disponibili al giocatore
    public int attempts;
//    matrice delle sequenze inserite come tentativi
    private final int[][] sequences;

//    Costruttore:

    public Player(int attempts) {

//        Inizializzazioni:

        this.attempts = attempts;
        sequences = new int[attempts][4];
    }

//    metodo di copia della sequenza inserita nell'interfaccia nella matrice dei tentativi

    public void setSequence(int tryN, int[] sequence) {
        System.arraycopy(sequence, 0, sequences[tryN], 0, sequence.length);
    }

//    metodo di richiamo di una sequenza della matrice

    @SuppressWarnings("unused")
    public int[] getSequence(int tryN) {
        return sequences[tryN];
    }
}
