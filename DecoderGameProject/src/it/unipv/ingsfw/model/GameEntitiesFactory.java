package it.unipv.ingsfw.model;

/**
 * Interfaccia per la factory di entità di gioco.
 * Definisce i metodi per creare un Encoder, un Decoder e un Game.
 */

public interface GameEntitiesFactory {

    /**
     * Crea un nuovo Encoder con il nome specificato.
     *
     * @param encoderName nome dell' encoder da creare.
     * @return istanza di Encoder con il nome specificato.
     */

    Encoder createEncoder(String encoderName);

    /**
     * Crea un nuovo Decoder con il nome specificato.
     *
     * @param decoderName nome del decoder da creare.
     * @return istanza di Decoder con il nome specificato.
     */

    Decoder createDecoder(String decoderName);

    /**
     * Crea un nuovo gioco.
     *
     * @return istanza di Game.
     */

    Game createGame();

}
