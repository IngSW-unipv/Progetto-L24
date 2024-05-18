package Logic;  //Definisce il package in cui si trova la classe Main

public class Main {

//    Punto di partenza del programma
    public static void main(String[] args) {

//        Creazione nuova istanza della classe Game
        Game newGame = new Game();

//        Avvio del Thread di gioco
        newGame.start();

    }
}
