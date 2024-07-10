package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.Colors;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ComboBox;
import it.unipv.ingsfw.view.ViewFacade;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class DecodingGame {

    private GameFacade gameFacade;
    private ViewFacade viewFacade;
    private PlayersController playersController;
    private GameController gameController;
    private NameInsertController nameInsertController;
    private DifficultySelectionController difficultySelectionController;

    public DecodingGame(GameFacade gameFacade, ViewFacade viewFacade) {

        this.gameFacade = gameFacade;
        this.viewFacade = viewFacade;
        this.playersController = new PlayersController(gameFacade);
        this.gameController = new GameController(gameFacade);
        this.nameInsertController = new NameInsertController(viewFacade, playersController, gameController);
        this.difficultySelectionController = new DifficultySelectionController(viewFacade, gameController);

//        viewFacade.createView();
//        viewFacade.createNameDialog();
//        setupViewListeners();
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

    protected void startGame() {
        playersController.getEncoder().generateSecretCode();
        gameController.getGame().start();
        System.out.println(gameController.getGame().getState());
        System.out.println(gameFacade.convertSecretCodeToString());
    }

    private void setupViewListeners() {
        /*viewFacade.addConfirmNameButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDecoderNameInput();
            }
        });*/

        /*viewFacade.addDifficultySetButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDifficultyChooseInput();
            }
        });*/

        viewFacade.addCheckSequenceButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameFacade.getGame().getTotAttempts() != 0) {
                    handleTurn();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Choose a game difficulty first!");
                }
            }
        });
    }

    /*public void initializeGame() {
        viewFacade.getMainView().getColorList(gameFacade.getColorList());
        viewFacade.showMainView();
        viewFacade.showDecoderNameDialog();
    }*/

    /*private void handleDecoderNameInput() {
        String decoderName = viewFacade.getDecoderName();
        if (decoderName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Decoder name not valid!");
        } else {

//            gameFacade.createGame(decoderName, new AutoEncoder(), viewFacade.getMainView());
            playersController.createPlayers(decoderName, new AutoEncoder(), viewFacade.getMainView());
            gameController.createNewGame(1);
            viewFacade.showGameInfo(gameController.getGame().getId(), decoderName,
                    playersController.getDecoder().getPoints());
//            gameFacade.startGame();
            startGame();
            viewFacade.hideDecoderNameDialog();
        }
    }*/

    /*private void handleDifficultyChooseInput() {
        viewFacade.applyDifficulty(gameFacade.setDifficulty(viewFacade.getDifficultyChosen()));
    }*/

    private void handleTurn() {
        if(gameFacade.hasAttemptsLeft()) {
            if(viewFacade.getMainView().checkDuplicateInSequence()) {
                ArrayList<Color> sequence = new ArrayList<>();
                for(ComboBox comboBox: viewFacade.getMainView().getComboBoxes()) {
                    sequence.add(Colors.values()[comboBox.getSelectedIndex()].getRgbColor());
                }
                int hint[] = gameFacade.playTurn(sequence);
                for(int i = 0; i < sequence.size(); i++) {
                    viewFacade.getMainView().getAttemptsTable().getModel().
                            setCellColor(gameFacade.getGame().getCurrentAttempt(), i+1, sequence.get(i));
                }
                viewFacade.getMainView().getAttemptsTable().getModel().
                        setValueAt(hint[0], gameFacade.getGame().getCurrentAttempt(), 0);
                viewFacade.getMainView().getAttemptsTable().getModel().
                        setValueAt(hint[1], gameFacade.getGame().getCurrentAttempt(), 5);
                gameFacade.endTurn();
            }
        }
    }
}
