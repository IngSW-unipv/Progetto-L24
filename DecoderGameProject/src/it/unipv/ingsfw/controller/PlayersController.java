package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.Observer;
import it.unipv.ingsfw.model.*;

import java.util.ArrayList;

/**
 * Controller che gestisce la creazione e la gestione dei giocatori nel gioco.
 * Interagisce con il GameFacade per creare e gestire Encoder e Decoder.
 */

public class PlayersController {

    private final GameFacade gameFacade;
    private final Observer observer;

    /**
     * Costruttore della classe PlayersController.
     * Inizializza il controller con GameFacade e un osservatore.
     *
     * @param gameFacade istanza del facade del modello del gioco.
     * @param observer osservatore a cui notificare i cambiamenti di stato.
     */

    public PlayersController(GameFacade gameFacade, Observer observer) {
        this.gameFacade = gameFacade;
        this.observer = observer;
    }

    /**
     * Crea un Encoder e un Decoder con i nomi e la strategia specificati.
     * Specifico per Encoder controllati da un utente.
     *
     * @param decoderName nome del decoder.
     * @param encoderName nome dell' encoder.
     * @param strategy strategia dell' encoder.
     */

    public void createPlayers(String decoderName, String encoderName, EncoderStrategy strategy) {
        this.gameFacade.createNewEncoder(encoderName, strategy, this.observer);
        this.gameFacade.createNewDecoder(decoderName, this.observer);
    }

    /**
     * Crea un Decoder con il nome specificato e un Encoder con nome "CPU" e la strategia specificata.
     * Specifico per Encoder controllati dal sistema.
     *
     * @param decoderName nome del decoder.
     * @param strategy strategia dell' encoder.
     */

    public void createPlayers(String decoderName, EncoderStrategy strategy) {
        this.gameFacade.createNewEncoder("CPU", strategy, this.observer);
        this.gameFacade.createNewDecoder(decoderName, this.observer);
    }

    /**
     * Genera il codice segreto tramite l' encoder.
     */

    public void secretCodeGeneration() {
        gameFacade.getEncoder().generateSecretCode();
    }

    /**
     * Recupera il nome del decoder.
     *
     * @return nome del decoder.
     */

    public String retrieveDecoderName() {
        return gameFacade.getDecoder().getName();
    }

    /**
     * Recupera i punti del decoder.
     *
     * @return punti del decoder.
     */

    public int retrieveDecoderPoints() {
        return gameFacade.getDecoder().getPoints();
    }

    /**
     * Recupera il codice segreto convertito in una lista di stringhe.
     *
     * @return lista di stringhe rappresentanti il codice segreto.
     */

    public ArrayList<String> getSecretCodeNames() {
        return gameFacade.convertSecretCodeToString();
    }
}
