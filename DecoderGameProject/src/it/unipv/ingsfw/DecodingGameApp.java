package it.unipv.ingsfw;

import it.unipv.ingsfw.controller.DecodingGame;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

public class DecodingGameApp {

    public static void main(String[] args) {

        GameFacade gameFacade = new GameFacade();
        ViewFacade viewFacade = new ViewFacade();

        DecodingGame decodingGame = new DecodingGame(gameFacade, viewFacade);
//        decodingGame.initializeGame();
        decodingGame.setupGame();
    }
}
