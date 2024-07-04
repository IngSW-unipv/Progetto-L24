package logic;  //definisce il package in cui è contenuta la classe CodeEvaluation

/**
 * Sistema di valutazione delle sequenze inserite dal giocatore rispetto al codice segreto per l'identificazione degli
 * indizi sul tentativo corrente.
 */
public class CodeEvaluation extends Thread {

//    Definizioni:

//    codice segreto
    private int[] code;
//    tentativo corrente
    private int[] guess;
//    indizi sul tentativo corrente
    private final int[] hints;

//    Costruttore:

    /**
     * Definizione caratteristiche del sistema.
     */
    public CodeEvaluation() {
//        Inizializzazioni:

        code = new int[4];
        guess = new int[4];
        hints = new int[2];

    }

    /**
     * Impostazione del codice segreto.
     * @param code
     * Il codice segreto.
     */
    public void setCode(int[] code) {
        this.code = code;
    }

    /**
     * Impostazione della sequenza di indizi.
     * @param guess
     * La sequenza di indizi.
     */
    public void setGuess(int[] guess) {
        this.guess = guess;
    }

    /**
     * Acquisizione della sequenza di indizi corrente.
     * @return
     * La sequenza di indizi corrente.
     */
    public int[] getHints() {
        return hints;
    }

    /**
     * Operazioni di confronto e valutazione delle sequenze di colori nel thread.
     */
    @Override
    public synchronized void run() {
        hints[0] = 0;
        hints[1] = 0;
        try {
            for(int i = 0; i < 4; i++) {

                if(guess[i] == code[i]) {
                    hints[1] += 1;      // posizione 1 dell'array per pioli indizio rightPos
                } else {

                    for(int j = 0; j < 4; j++) {

                        if(j != i && guess[i] == code[j]) {
                            hints[0] += 1;      // posizione 0 dell'array per pioli indizio wrongPos
                        }

                    }

                }
            }
        }catch (Exception e) {
            System.out.println("An error occurred during code evaluation!");
        }
    }
}
