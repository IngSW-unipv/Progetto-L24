package Logic;  //definisce il package in cui è contenuta la classe CodeEvaluation

public class CodeEvaluation extends Thread {

//    Definizioni:

//    codice segreto
    private int[] code;
//    tentativo corrente
    private int[] guess;
//    indizi sul tentativo corrente
    private final int[] hints;

//    Costruttore:

    public CodeEvaluation() {
//        Inizializzazioni:

        code = new int[4];
        guess = new int[4];
        hints = new int[2];

    }

//    metodo setter per codice segreto
    public void setCode(int[] code) {
        this.code = code;
    }

//    metodo setter per tentativo corrente
    public void setGuess(int[] guess) {
        this.guess = guess;
    }

//    metodo getter per indizi correnti
    public int[] getHints() {
        return hints;
    }

//    metodo di esecuzione istruzioni nel Thread
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
