package logic;  //Definisce il package in cui si trova la classe Game

import graphics.MainGui;    //definisce l'importazione della classe MainGui dal package Graphics
import graphics.Colors;     //definisce l'importazione di Enum Colors per l'acquisizione del numero di entità

/**
 * Sistema di gioco.
 */
public class Game extends Thread {

//    Definizioni:

//    interfaccia grafica di gioco
    MainGui mainGui;
//    codice segreto
    private final int[] secretCode;

//    metodo di esecuzione azioni del Thread

    @Override
    public synchronized void run() {

//        Generazione codice segreto e gestione eventuali eccezioni
        try {
            setSecretCode();
        } catch (ArithmeticException e) {
            System.out.println("Error calculating new secret code!");
        }
//        inizializzazione interfaccia grafica e gestione eventuali eccezioni
        try {
            mainGui = new MainGui(secretCode);
        } catch (Exception ex) {
            System.out.println("Error in GUI!");
        }
    }

    //    Costruttore:

    /**
     * Definizione caratteristiche del gioco.
     */
    public Game() {
//        inizializzazione array codice segreto
        secretCode = new int[4];
    }

    /**
     * Impostazione del codice segreto per la partita.
     */
    void setSecretCode() {
//        definizione numero totale di colori disponibili
        int colorDim = Colors.values().length;
//        inizializzazione cella 0 con valore pseudocasuale calcolato
        secretCode[0] = (int) (Math.random() * colorDim);
//        ripetizione generazione valori per altre celle
        for (int i = 1; i < secretCode.length; i++) {

            secretCode[i] = (int) (Math.random() * colorDim);
//            esclusione valori doppi
            for(int j = 0; j < i; j++) {

                while (secretCode[i] == secretCode[j]) {
                    secretCode[i] = (int) (Math.random() * colorDim);
                    j = 0;
                }
            }
        }
    }

    /**
     * Acquisizione del codice segreto.
     * @return
     * Sequenza che rappresenta il codice segreto.
     */
    public int[] getSecretCode() {
        return secretCode;
    }

}
