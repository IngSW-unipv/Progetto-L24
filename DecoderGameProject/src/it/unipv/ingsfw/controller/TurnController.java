package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.view.ViewFacade;

import java.awt.*;
import java.util.ArrayList;

/**
 * Controller che gestisce i turni di gioco.
 * Interagisce con il GameFacade, ViewFacade, PlayersController e GameController
 * per gestire le operazioni di gioco durante ogni turno.
 */

public class TurnController {

    private final ViewFacade viewFacade;
    private final PlayersController playersController;
    private final GameController gameController;

    /**
     * Costruttore della classe TurnController.
     * Inizializza il controller con il GameFacade, ViewFacade, PlayersController e GameController.
     *
     * @param viewFacade istanza del facade della vista.
     * @param playersController controller dei giocatori.
     * @param gameController controller del gioco.
     */

    public TurnController(ViewFacade viewFacade,
                          PlayersController playersController, GameController gameController) {
        this.viewFacade = viewFacade;
        this.playersController = playersController;
        this.gameController = gameController;
    }

    /**
     * Aggiunge un listener al pulsante per verificare la sequenza.
     */

    public void playTurnListener() {

        viewFacade.addCheckSequenceButtonListener(e -> {
//            Controllo per la presenza di un gioco
            if(gameController.getGame() == null) {
//                Visualizzazione dell'errore in caso venga tentata l'analisi
//                di una sequenza senza avere definito una difficoltà e,
//                conseguentemente la definizione di un nuovo gioco
                viewFacade.showDifficultyErrorNotChosen();
//                Controllo simile al precedente per i game successivi al primo
            } else if (gameController.retrieveTotalAttempts() == 0) {
                viewFacade.showDifficultyErrorNotChosen();
            } else {
                handleTurn();
            }
        });
    }

    /**
     * Gestisce un turno di gioco.
     * Verifica che ci siano tentativi rimanenti e che la sequenza inserita sia valida,
     * poi gioca il turno e aggiorna la vista di conseguenza.
     */

    private void handleTurn() {
//        Controllo sulla presenza di tentativi rimanenti per il decoder
        if(gameController.hasThisGameAttemptsLeft()) {
//            Controllo per l'assenza di codici (Colori) duplica nella sequenza
            if (viewFacade.hasNoneSequenceDuplicates()) {
//                Acquisizione della sequenza in variabile locale
                ArrayList<Color> sequence = viewFacade.retrieveNewSequence();
//                Esecuzione operazioni di salvataggio sequenza, confronto con
//                il codice segreto e definizione dell'indizio
                gameController.startGameTurn(sequence);
//                visualizzazione della sequenza inserita nella vista
                viewFacade.showNewSequence(gameController.retrieveAttemptsPlayed(), sequence);
//                terminazione turno con l'aggiornamento del numero di tentativi
//                effettuati e quelli rimanenti
                gameController.endGameTurn();
//                Controllo sull'indizio per verificare se si è raggiunta la vittoria
//                o siano finiti i tentativi comportando la fine del gioco
                if (gameController.checkWin() || !gameController.hasThisGameAttemptsLeft()) {
                    endGame();
                }
                System.out.println(gameController.retrieveAttemptsPlayed());
            }
        }
    }

    private void endGame() {
//        Controllo di aver vinto
        if(gameController.checkWin()) {
//            Disabilitazione bottone di verifica sequenze
            viewFacade.disableSequenceCheckButton();
//            Aggiornamento punteggio del decoder e notifica aggiornamento vista
            gameController.winThisGame();
//            Visualizzazione messaggio di vittoria
            viewFacade.showVictoryMessage(gameController.getGame().getAttemptPlayed());
            System.out.println(playersController.retrieveDecoderPoints());
        } else {
//            Disabilitazione bottone di verifica sequenze
            viewFacade.disableSequenceCheckButton();
//            Aggiornamento punteggio encoder
            gameController.looseThisGame();
//            Visualizzazione messaggio di sconfitta
            viewFacade.showLooseMessage(gameController.executeSecretCodeConversion());
        }
//        Modifica dello stato del gioco
        gameController.endGame();
    }
}
