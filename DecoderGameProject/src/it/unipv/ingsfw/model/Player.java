package it.unipv.ingsfw.model;

/**
 * Classe astratta che rappresenta un giocatore nel gioco.
 * Estende la classe Observable per gestire gli observer che monitorano lo stato del giocatore.
 */

public abstract class Player extends Observable {

    private String name;
    private int points;

    /**
     * Costruttore che inizializza un giocatore con il nome specificato e zero punti.
     *
     * @param name il nome del giocatore.
     */

    public Player(String name) {
        super();
        this.name = name;
        this.points = 0;
    }

    /**
     * Costruttore che inizializza un giocatore predefinito con il nome "Player1" e zero punti.
     * Utilizzato come costruttore di default.
     */

    public Player() {
        super();
        this.name = "Player1";
        this.points = 0;
    }

    /**
     * Imposta il nome del giocatore.
     *
     * @param name il nuovo nome da assegnare al giocatore.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il nome del giocatore.
     *
     * @return il nome del giocatore.
     */

    public String getName() {
        return name;
    }

    /**
     * Imposta i punti del giocatore.
     *
     * @param points i nuovi punti da assegnare al giocatore.
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Restituisce i punti attuali del giocatore.
     *
     * @return i punti attuali del giocatore.
     */

    public int getPoints() {
        return points;
    }

}
