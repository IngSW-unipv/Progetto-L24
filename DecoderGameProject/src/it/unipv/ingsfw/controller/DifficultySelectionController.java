package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.view.ViewFacade;

/**
 * Controller che gestisce la selezione della difficoltà del gioco.
 * Interagisce con la vista e i controller dei giocatori e del gioco per impostare
 * la difficoltà e inizializzare una nuova partita.
 */

public class DifficultySelectionController {

    private final ViewFacade viewFacade;
    private final PlayersController playersController;
    private final GameController gameController;

    /**
     * Costruttore della classe DifficultySelectionController.
     * Inizializza il controller con il ViewFacade, PlayersController e GameController.
     *
     * @param viewFacade istanza del facade della vista.
     * @param playersController controller dei giocatori.
     * @param gameController controller del gioco.
     */

    public DifficultySelectionController(ViewFacade viewFacade, PlayersController playersController,
                                         GameController gameController) {
        this.viewFacade = viewFacade;
        this.playersController = playersController;
        this.gameController = gameController;
    }

    /**
     * Aggiunge un listener al pulsante di impostazione della difficoltà.
     */

    public void difficultySelectionListener() {
        viewFacade.addDifficultySetButtonListener(e -> handleDifficultyChooseInput());
    }

    /**
     * Gestisce la scelta della difficoltà.
     * Inizializza una nuova partita, genera il codice segreto, avvia il gioco e
     * aggiorna le informazioni sulla difficoltà nella vista.
     */

    private void handleDifficultyChooseInput() {
//        ID del gioco di default
        int newGameId = 1;
//        Controllo sulla presenza di un gioco precedente
        if(gameController.hasGame()) {
//            Controllo sullo stato del gioco precedente
            if(gameController.checkState("Ended")) {
//                Incremento dell'ID del gioco
                newGameId = gameController.retrieveId() + 1;
            }
        }
//        Creazione nuovo gioco
        gameController.newGame(newGameId);
//        Definizione nuovo codice segreto
        playersController.secretCodeGeneration();
//        Avvio del gioco
        gameController.startGame();
//        Acquisizione e salvataggio informazioni sulla difficoltà scelta
        gameController.updateGameDifficultyInfo(viewFacade.getDifficultyChosen());
//        Aggiornamento della vista con le nuove informazioni
        viewFacade.applyDifficulty(gameController.retrieveTotalAttempts());
        viewFacade.showGameInfo(gameController.retrieveId(), playersController.retrieveDecoderName(),
                playersController.retrieveDecoderPoints());
//        Abilitazione del pulsante di controllo sequenze
        viewFacade.enableSequenceCheckButton();
        System.out.println(playersController.getSecretCodeNames());
    }

}
