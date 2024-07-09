package it.unipv.ingsfw;

import it.unipv.ingsfw.controller.DecodingGame;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

public class DecodingGameApp {

    public static void main(String[] args) {

        ViewFacade viewFacade = new ViewFacade();
        GameFacade gameFacade = new GameFacade();

        DecodingGame decodingGame = new DecodingGame(gameFacade, viewFacade);
        decodingGame.initializeGame();

    }
}
