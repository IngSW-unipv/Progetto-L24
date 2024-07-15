package it.unipv.ingsfw;

/**
 * Interfaccia per gli oggetti che osservano e ricevono aggiornamenti dal soggetto osservato.
 * Definisce due metodi di aggiornamento per gestire informazioni specifiche.
 */

public interface Observer {

    /**
     * Metodo di aggiornamento per ricevere un nuovo suggerimento (hint) relativo a un tentativo.
     *
     * @param newHint        il nuovo suggerimento (hint) ricevuto.
     * @param currentAttempt il numero del tentativo corrente.
     */

    void update(int[] newHint, int currentAttempt);

    /**
     * Metodo di aggiornamento per ricevere informazioni aggiornate su punti e stato del giocatore.
     *
     * @param id       l'identificativo del giocatore.
     * @param name     il nome del giocatore.
     * @param newPoints i nuovi punti del giocatore.
     */

    void update(int id, String name, int newPoints);

}
