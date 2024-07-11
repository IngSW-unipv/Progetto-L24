package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.Colors;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ComboBox;
import it.unipv.ingsfw.view.ViewFacade;


import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;

public class DecodingGame {

    private final GameFacade gameFacade;
    private final ViewFacade viewFacade;
    private final NameInsertController nameInsertController;
    private final DifficultySelectionController difficultySelectionController;

    public DecodingGame(GameFacade gameFacade, ViewFacade viewFacade) {

        this.gameFacade = gameFacade;
        this.viewFacade = viewFacade;
        PlayersController playersController = new PlayersController(gameFacade, viewFacade);
        GameController gameController = new GameController(gameFacade);
        this.nameInsertController = new NameInsertController(viewFacade, playersController, gameController);
        this.difficultySelectionController = new DifficultySelectionController(viewFacade, gameController);
    }

    public void setupGame() {
        viewFacade.createView();
        viewFacade.createNameDialog();
        viewFacade.getMainView().getColorList(gameFacade.getColorList());
        nameInsertController.nameInsertListener();
        difficultySelectionController.difficultySelectionListener();
        setupViewListeners();
        viewFacade.showMainView();
        viewFacade.showDecoderNameDialog();
    }

    private void setupViewListeners() {

        viewFacade.addCheckSequenceButtonListener(e -> {
            if(gameFacade.getGame().getTotAttempts() != 0) {
                handleTurn();
            } else {
                JOptionPane.showMessageDialog(null, "Error: Choose a game difficulty first!");
            }
        });
    }

    private void handleTurn() {
        if(gameFacade.hasAttemptsLeft()) {
            if(viewFacade.getMainView().checkDuplicateInSequence()) {
                ArrayList<Color> sequence = new ArrayList<>();
                for(ComboBox comboBox: viewFacade.getMainView().getComboBoxes()) {
                    sequence.add(Colors.values()[comboBox.getSelectedIndex()].getRgbColor());
                }
                gameFacade.playTurn(sequence);
                for(int i = 0; i < sequence.size(); i++) {
                    viewFacade.getMainView().getAttemptsTable().getModel().
                            setCellColor(gameFacade.getGame().getCurrentAttempt(), i+1, sequence.get(i));
                }
                gameFacade.endTurn();
                System.out.println(gameFacade.getAttemptsLeft());
            }
        }
    }
}
