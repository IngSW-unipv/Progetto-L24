package it.unipv.ingsfw;

import it.unipv.ingsfw.controller.DecodingGame;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

/**
 * Il punto di inizio dell'applicazione DecodingGame.
 * La classe imposta i componenti necessari
 * come il game facade e il view facade, e poi avvia la
 * predisposizione del gioco.
 */

public class DecodingGameApp {

    /**
     * Il metodo principale dove l'applicazione DecodingGame inizia.
     * Inizializza le istanze singole di GameFacade e ViewFacade,
     * e poi crea un'istanza di DecodingGame per impostare e avviare il gioco.
     *
     * @param args argomenti della riga di comando passati all'applicazione (non utilizzati).
     */

    public static void main(String[] args) {

        // Istanza singleton del game facade
        GameFacade gameFacade = GameFacade.getInstance();

        // Istanza singleton del view facade
        ViewFacade viewFacade = ViewFacade.getInstance();

        // Creazione e impostazione del gioco di decodifica con i facades inizializzati
        DecodingGame decodingGame = new DecodingGame(gameFacade, viewFacade);
        decodingGame.setupGame();
    }
}
