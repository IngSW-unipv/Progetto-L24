package it.unipv.ingsfw.controller;

import it.unipv.ingsfw.model.*;

import java.util.ArrayList;

public class PlayersController {

    private GameFacade gameFacade;

    public PlayersController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public void createPlayers(String decoderName, String encoderName, EncoderStrategy strategy, Observer observer) {
        this.gameFacade.createNewDecoder(decoderName, observer);
        this.gameFacade.createNewEncoder(encoderName, strategy, observer);
    }

    public void createPlayers(String decoderName, EncoderStrategy strategy, Observer observer) {
        this.gameFacade.createNewDecoder(decoderName, observer);
        this.gameFacade.createNewEncoder("CPU", strategy, observer);
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
