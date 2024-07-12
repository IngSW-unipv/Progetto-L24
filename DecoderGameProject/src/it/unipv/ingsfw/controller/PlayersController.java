package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.Observer;
import it.unipv.ingsfw.model.*;

import java.util.ArrayList;

public class PlayersController {

    private final GameFacade gameFacade;
    private final Observer observer;

    public PlayersController(GameFacade gameFacade, Observer observer) {
        this.gameFacade = gameFacade;
        this.observer = observer;
    }

    public void createPlayers(String decoderName, String encoderName, EncoderStrategy strategy) {
        this.gameFacade.createNewEncoder(encoderName, strategy, this.observer);
        this.gameFacade.createNewDecoder(decoderName, this.observer);
    }

    public void createPlayers(String decoderName, EncoderStrategy strategy) {
        this.gameFacade.createNewEncoder("CPU", strategy, this.observer);
        this.gameFacade.createNewDecoder(decoderName, this.observer);
    }

    public Encoder getEncoder() {
        return gameFacade.getEncoder();
    }

    public Decoder getDecoder() {
        return gameFacade.getDecoder();
    }

    public ArrayList<String> getSecretCodeNames() {
        return gameFacade.convertSecretCodeToString();
    }
}
