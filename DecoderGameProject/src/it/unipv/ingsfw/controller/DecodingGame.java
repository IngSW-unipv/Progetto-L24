package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

/**
 * La classe gestisce il gioco di decodifica.
 * Nello specifico gestisce l'interazione tra il modello del gioco (GameFacade)
 * e la vista (ViewFacade) tramite vari controller.
 */

public class DecodingGame {

    private final GameFacade gameFacade;
    private final ViewFacade viewFacade;
    private final NameInsertController nameInsertController;
    private final DifficultySelectionController difficultySelectionController;
    private final TurnController turnController;

    /**
     * Costruttore della classe DecodingGame.
     * Inizializza i controller necessari per gestire il flusso del gioco.
     *
     * @param gameFacade istanza del facade del modello del gioco.
     * @param viewFacade istanza del facade della vista.
     */

    public DecodingGame(GameFacade gameFacade, ViewFacade viewFacade) {

        this.gameFacade = gameFacade;
        this.viewFacade = viewFacade;
        PlayersController playersController = new PlayersController(gameFacade, viewFacade);
        GameController gameController = new GameController(gameFacade);
        this.nameInsertController = new NameInsertController(viewFacade, playersController);
        this.difficultySelectionController = new DifficultySelectionController(viewFacade, playersController,
                gameController);
        this.turnController = new TurnController(viewFacade, playersController, gameController);
    }

    /**
     * Imposta il gioco inizializzando i componenti della vista e
     * aggiungendo i listener necessari per le interazioni dell'utente.
     */

    public void setupGame() {
        viewFacade.setColorList(gameFacade.getColorList());
        nameInsertController.nameInsertListener();
        difficultySelectionController.difficultySelectionListener();
        turnController.playTurnListener();
        viewFacade.showMainView();
        viewFacade.showDecoderNameDialog();
    }
}
