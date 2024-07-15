package it.unipv.ingsfw.model;

/**
 * Classe che rappresenta un giocatore di tipo Decoder.
 * Estende la classe astratta Player e rappresenta un giocatore che
 * partecipa al gioco nel ruolo di decodificatore.
 */

public class Decoder extends Player {

    private static Decoder instance;

    /**
     * Costruttore della classe Decoder.
     *
     * @param name nome del decodificatore.
     */

    private Decoder(String name) {
        super(name);
    }

    /**
     * Restituisce l'istanza singleton di Decoder.
     *
     * @param name il nome da applicare al Decoder.
     * @return l'istanza singleton del Decoder.
     */

    public static Decoder getInstance(String name) {
        if(instance == null) {
            instance = new Decoder(name);
        }
        return instance;
    }

    /**
     * Esegue il reset dell' istanza singleton dell' Decoder.
     */

    public static void resetInstance() {
        instance = null;
    }

}
