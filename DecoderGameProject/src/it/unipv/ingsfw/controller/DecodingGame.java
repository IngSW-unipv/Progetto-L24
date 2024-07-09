package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.AutoEncoder;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecodingGame {

    private GameFacade gameFacade;
    private ViewFacade viewFacade;

    public DecodingGame(GameFacade gameFacade, ViewFacade viewFacade) {

        this.gameFacade = gameFacade;
        this.viewFacade = viewFacade;


        viewFacade.createView();
        viewFacade.createNameDialog();
        setupViewListeners();
    }

    private void setupViewListeners() {
        viewFacade.addConfirmNameButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDecoderNameInput();
            }
        });

        viewFacade.addDifficultySetButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void initializeGame() {
        viewFacade.getMainView().getColorList(gameFacade.getColorList());
        viewFacade.showMainView();
        viewFacade.showDecoderNameDialog();
    }

    private void handleDecoderNameInput() {
        String decoderName = viewFacade.getDecoderName();
        if (decoderName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Decoder name not valid!");
        } else {

            gameFacade.createGame(decoderName, new AutoEncoder(), viewFacade.getMainView());
            viewFacade.updateMainView(gameFacade.getGame().getId(), decoderName, gameFacade.getDecoder().initializePoints() );
            gameFacade.startGame();
            viewFacade.hideDecoderNameDialog();
        }
    }

    private void handleDifficultyChoseInput() {
        String difficulty = viewFacade.getDifficultyChosen();
        if (gameFacade.getDecoder().getName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Decoder name not defined!");
        } else {
            viewFacade.setTable(gameFacade.setDifficulty(difficulty));
        }
    }
}
