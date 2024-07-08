package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.AutoGenerationSecretCode;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;
import it.unipv.ingsfw.model.SecretCodeStrategy;


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
    }

    public void initializeGame() {
        viewFacade.showMainView();
        viewFacade.showDecoderNameDialog();
    }

    private void handleDecoderNameInput() {
        String decoderName = viewFacade.getDecoderName();
        if (decoderName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Decoder name not valid!");
        } else {

            gameFacade.createGame(decoderName, new AutoGenerationSecretCode(), viewFacade.getMainView());
            viewFacade.updateMainView(gameFacade.getGame().getId(), decoderName, gameFacade.getDecoder().initializePoints() );
            gameFacade.startGame();
            viewFacade.hideDecoderNameDialog();
        }
    }
}
