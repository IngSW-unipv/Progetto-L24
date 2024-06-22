package logic;  //Definisce il package in cui si trova la classe Main

/**
 * Classe contenente il metodo di inizio del programma di gioco.
 */
public class Main {

    /**
     * Punto di Inizio del programma di gioco.
     * @param args
     * Valori eventualmente passati al programma dalla console.
     */
    public static void main(String[] args) {

//        Creazione nuova istanza della classe Game
        Game newGame = new Game();

//        Avvio del Thread di gioco
        newGame.start();

    }
}
