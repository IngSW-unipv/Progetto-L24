package it.unipv.ingsfw.model;

/**
 * Implementazione concreta dell'interfaccia GameEntitiesFactory.
 * Questa factory crea istanze concrete di Encoder, Decoder e Game.
 */

public class ConcreteGameEntitiesFactory implements GameEntitiesFactory {

    /**
     * Crea un nuovo Encoder con il nome specificato.
     *
     * @param encoderName nome dell' encoder da creare.
     * @return istanza singleton di Encoder con il nome specificato.
     */

    @Override
    public Encoder createEncoder(String encoderName) {
        return Encoder.getInstance(encoderName);
    }

    /**
     * Crea un nuovo Decoder con il nome specificato.
     *
     * @param decoderName nome del decoder da creare.
     * @return istanza singleton di Decoder con il nome specificato.
     */

    @Override
    public Decoder createDecoder(String decoderName) {
        return Decoder.getInstance(decoderName);
    }

    /**
     * Crea un nuovo gioco.
     *
     * @return istanza di Game.
     */

    @Override
    public Game createGame() {
        return new Game();
    }
}
