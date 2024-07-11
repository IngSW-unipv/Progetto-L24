package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.view.ViewFacade;

public class DifficultySelectionController {

    private final ViewFacade viewFacade;
    private final GameController gameController;

    public DifficultySelectionController(ViewFacade viewFacade, GameController gameController) {
        this.viewFacade = viewFacade;
        this.gameController = gameController;
    }

    public void difficultySelectionListener() {
        viewFacade.addDifficultySetButtonListener(e -> handleDifficultyChooseInput());
    }

    private void handleDifficultyChooseInput() {
        String difficulty = viewFacade.getDifficultyChosen();
        gameController.getGame().defineTotalAttempts(difficulty);
        gameController.setAttemptsLeft();
        gameController.getGame().initializeHints(gameController.getGame().getTotAttempts());
        viewFacade.applyDifficulty(gameController.getGame().getTotAttempts());
    }

}
