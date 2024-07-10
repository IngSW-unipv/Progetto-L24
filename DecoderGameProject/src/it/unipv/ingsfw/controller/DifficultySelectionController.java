package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultySelectionController {

    private ViewFacade viewFacade;
    private GameController gameController;

    public DifficultySelectionController(ViewFacade viewFacade, GameController gameController) {
        this.viewFacade = viewFacade;
        this.gameController = gameController;
    }

    public void difficultySelectionListener() {
        viewFacade.addDifficultySetButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDifficultyChooseInput();
            }
        });
    }

    private void handleDifficultyChooseInput() {
        String difficulty = viewFacade.getDifficultyChosen();
        gameController.getGame().defineTotalAttempts(difficulty);
        gameController.setAttemptsLeft();
        gameController.getGame().initializeHints(gameController.getGame().getTotAttempts());
        viewFacade.applyDifficulty(gameController.getGame().getTotAttempts());
    }

}
