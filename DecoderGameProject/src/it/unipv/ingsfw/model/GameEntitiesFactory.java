package it.unipv.ingsfw.model;

public interface GameEntitiesFactory {

    Encoder createEncoder(String encoderName);
    Decoder createDecoder(String decoderName);
    Game createGame();

}
