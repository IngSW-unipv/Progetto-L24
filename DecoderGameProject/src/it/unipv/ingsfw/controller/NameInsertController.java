package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.AutoEncoder;
import it.unipv.ingsfw.view.ViewFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameInsertController {

    private ViewFacade viewFacade;
    private PlayersController playersController;
    private GameController gameController;

    public NameInsertController(ViewFacade viewFacade, PlayersController playersController,
                                GameController gameController) {
        this.viewFacade = viewFacade;
        this.playersController = playersController;
        this.gameController = gameController;
    }

    public void nameInsertListener() {
        viewFacade.addConfirmNameButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDecoderNameInput();
            }
        });
    }

    private void handleDecoderNameInput() {
        String decoderName = viewFacade.getDecoderName();
        if (decoderName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Decoder name not valid!");
        } else {

//            gameFacade.createGame(decoderName, new AutoEncoder(), viewFacade.getMainView());
            playersController.createPlayers(decoderName, new AutoEncoder(), viewFacade.getMainView());
            gameController.createGame(1);

            viewFacade.showGameInfo(gameController.getGame().getId(), decoderName,
                    playersController.getDecoder().getPoints());

            playersController.getEncoder().generateSecretCode();
            gameController.getGame().start();

            System.out.println(gameController.getGame().getState());
            System.out.println(playersController.getSecretCodeNames());

            viewFacade.hideDecoderNameDialog();
        }
    }

}
