package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.Game;
import it.unipv.ingsfw.model.GameFacade;

import java.awt.*;
import java.util.ArrayList;

/**
 * Controller che gestisce le operazioni relative al gioco.
 * Interagisce con il GameFacade per creare, avviare, terminare e gestire il gioco.
 */

public class GameController {

    private final GameFacade gameFacade;

    /**
     * Costruttore della classe GameController.
     * Inizializza il controller con il GameFacade.
     *
     * @param gameFacade istanza del facade del modello del gioco.
     */

    public GameController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    /**
     * Crea un nuovo gioco con l'identificatore specificato.
     *
     * @param id identificatore del nuovo gioco.
     */

    public void newGame(int id) {
        gameFacade.createNewGame(id);
    }

    /**
     * Recupera l'istanza del gioco attuale.
     *
     * @return istanza del gioco attuale.
     */

    public Game getGame() {
        return gameFacade.getGame();
    }

    /**
     * Avvia il gioco.
     */

    public void startThisGame() {
        gameFacade.startGame();
    }

    /**
     * Termina il gioco.
     */

    public void endThisGame() {
        gameFacade.endGame();
    }

    /**
     * Verifica se lo stato del gioco corrisponde allo stato specificato.
     *
     * @param state stato da verificare.
     * @return true se lo stato corrisponde, false altrimenti.
     */

    public boolean checkThisGameState(String state) {
        return gameFacade.getGameState().equals(state);
    }

    /**
     * Verifica se il giocatore ha vinto.
     *
     * @return true se il giocatore ha vinto, false altrimenti.
     */

    public boolean checkWin() {
        return gameFacade.checkWinHint();
    }

    /**
     * Recupera l'identificatore del gioco attuale.
     *
     * @return identificatore del gioco attuale.
     */

    public int retrieveId() {
        return gameFacade.getThisGameId();
    }

    /**
     * Recupera il numero totale di tentativi del gioco.
     *
     * @return numero totale di tentativi.
     */

    public int retrieveTotalAttempts() {
        return gameFacade.getThisGameTotalAttempts();
    }

    /**
     * Recupera il numero di tentativi già giocati.
     *
     * @return numero di tentativi giocati.
     */

    public int retrieveAttemptsPlayed() {
        return gameFacade.getThisGameAttemptsPlayed();
    }

    /**
     * Controlla la presenza di tentativi rimanenti per il gioco in corso.
     *
     * @return true se sono presenti tentativi rimanenti, false se sono terminati
     *      i tentativi a disposizione per il gioco in corso.
     */

    public boolean hasThisGameAttemptsLeft() {
        return gameFacade.hasAttemptsLeft();
    }

    /**
     * Richiede alla facade del modello di eseguire le operazioni necessarie
     * allo svolgimento del turno.
     *
     * @param sequence la sequenza inserita dal Decoder nel turno odierno.
     */

    public void startGameTurn(ArrayList<Color> sequence) {
        gameFacade.playTurn(sequence);
    }

    /**
     * Richiede alla facade del modello di eseguire le operazioni necessarie
     * alla terminazione del turno.
     */

    public void endGameTurn() {
        gameFacade.endTurn();
    }

    /**
     * Richiede alla facade del modello di eseguire le operazioni necessarie
     * quando si vince la partita.
     */

    public void winThisGame() {
        gameFacade.winGame();
    }

    /**
     * Richiede alla facade del modello di eseguire le operazioni necessarie
     * quando si perde la partita.
     */

    public void looseThisGame() {
        gameFacade.looseGame();
    }

    /**
     * Aggiorna le informazioni sulla difficoltà del gioco.
     *
     * @param difficulty difficoltà da impostare.
     */

    public void updateGameDifficultyInfo(String difficulty) {
        gameFacade.getGame().defineTotalAttempts(difficulty);
        gameFacade.initializeAttemptsLeft();
        gameFacade.getGame().initializeHints(gameFacade.getThisGameTotalAttempts());
    }

    /**
     * Richiede la conversione del codice segreto in un formato più comprensibile.
     *
     * @return la lista dei colori del codice segreto convertita.
     */

    public ArrayList<String> executeSecretCodeConversion() {
        return gameFacade.convertSecretCodeToString();
    }

    /**
     * Verifica se esiste un gioco attuale.
     *
     * @return true se esiste un gioco, false altrimenti.
     */

    public boolean hasGame() {
        return gameFacade.getGame() != null;
    }

}
