package Logic;

import Graphics.MainGui;

public class Game {

//    Definizioni:

//    codice segreto
    private final int[] secretCode;

//    Costruttore:

    public Game() {
//        inizializzazione array codice segreto
        secretCode = new int[4];
//        effettiva generazione codice segreto
        setSecretCode();
//        Generazione interfaccia grafica di gioco
        MainGui gui = new MainGui(secretCode);

    }

//    metodo per la generazione di codici segreti

    private void setSecretCode() {
//        inizializzazione cella 0 con primo valore pseudocasuale calcolato
        secretCode[0] = (int) (Math.random() * 6);
//        ripetizione generazione valori per altre celle
        for (int i = 1; i < secretCode.length; i++) {

            secretCode[i] = (int) (Math.random() * 6);
//            esclusione valori doppi
            for(int j = 0; j < i; j++) {

                while (secretCode[i] == secretCode[j]) {
                    secretCode[i] = (int) (Math.random() * 6);
                    j = 0;
                }
            }
        }
    }

//    metodo per il richiamo di codici segreti

    public int[] getSecretCode() {
        return secretCode;
    }

}
