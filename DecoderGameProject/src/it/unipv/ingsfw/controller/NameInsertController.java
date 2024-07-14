package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.AutoEncoder;
import it.unipv.ingsfw.view.ViewFacade;

import javax.swing.*;

/**
 * Controller che gestisce l'inserimento del nome del decoder.
 * Interagisce con la vista per raccogliere il nome del decoder e
 * crea i giocatori attraverso il PlayersController.
 */

public class NameInsertController {

    private final ViewFacade viewFacade;
    private final PlayersController playersController;

    /**
     * Costruttore della classe NameInsertController.
     * Inizializza il controller con il ViewFacade e il PlayersController.
     *
     * @param viewFacade istanza del facade della vista.
     * @param playersController controller dei giocatori.
     */

    public NameInsertController(ViewFacade viewFacade, PlayersController playersController) {
        this.viewFacade = viewFacade;
        this.playersController = playersController;
    }

    /**
     * Aggiunge un listener al pulsante di conferma del nome del decoder.
     */

    public void nameInsertListener() {
        viewFacade.addConfirmNameButtonListener(e -> handleDecoderNameInput());
    }

    /**
     * Gestisce l'inserimento del nome del decoder.
     * Verifica che il nome non sia vuoto, crea i giocatori e aggiorna la vista.
     */

    private void handleDecoderNameInput() {
//        Variabile locale ospitante il nome del giocatore acquisito dalla vista
        String decoderName = viewFacade.getDecoderName();
//        Controllo sulla presenza del nome acquisito
        if (decoderName.isEmpty()) {
//            Visualizzazione messaggio di errore in caso di nome vuoto
            viewFacade.showNameErrorNotValid();
        } else {
//            Creazione di Encoder e Decoder se il nome non risulta vuoto
            playersController.createPlayers(decoderName, new AutoEncoder());
//            Visualizzazione informazioni giocatore sulla vista
            viewFacade.showGameInfo(0, decoderName,
                    playersController.retrieveDecoderPoints());
//            Oscuramento finestra di inserimento del nome del Decoder
            viewFacade.hideDecoderNameDialog();
        }
    }

}
