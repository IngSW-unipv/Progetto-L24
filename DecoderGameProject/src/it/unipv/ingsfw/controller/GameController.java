package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.Game;
import it.unipv.ingsfw.model.GameFacade;

public class GameController {

    private final GameFacade gameFacade;

    public GameController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public void createGame(int id) {
        gameFacade.createNewGame(id);
    }

    public Game getGame() {
        return gameFacade.getGame();
    }

    public void setAttemptsLeft() {
        gameFacade.initializeAttemptsLeft();
    }

}
