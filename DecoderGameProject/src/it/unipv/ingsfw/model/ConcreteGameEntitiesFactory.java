package it.unipv.ingsfw.model;

public class ConcreteGameEntitiesFactory implements GameEntitiesFactory {
    @Override
    public Encoder createEncoder(String encoderName) {
        return new Encoder(encoderName);
    }

    @Override
    public Decoder createDecoder(String decoderName) {
        return new Decoder(decoderName);
    }

    @Override
    public Game createGame() {
        return new Game();
    }
}
