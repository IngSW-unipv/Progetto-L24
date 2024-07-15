package it.unipv.ingsfw.model;

/**
 * Enum che rappresenta i livelli di difficoltà del gioco.
 * Ogni livello di difficoltà ha un numero massimo di tentativi e un punteggio associato.
 */

public enum Difficulty {

    /**
     * Livello di difficoltà EASY:
     * - Massimo 15 tentativi.
     * - Punteggio 1.
     */

    EASY(15, 1),

    /**
     * Livello di difficoltà NORMAL:
     * - Massimo 10 tentativi.
     * - Punteggio 2.
     */

    NORMAL(10, 2),

    /**
     * Livello di difficoltà HARD:
     * - Massimo 5 tentativi.
     * - Punteggio 3.
     */

    HARD(5, 3);

    private final int attempts;
    private final int points;

    /**
     * Costruttore privato per l' enum Difficulty.
     *
     * @param attempts numero massimo di tentativi per questo livello di difficoltà.
     * @param points punteggio associato a questo livello di difficoltà.
     */

    Difficulty(int attempts, int points) {
        this.attempts = attempts;
        this.points = points;
    }

    /**
     * Restituisce il numero massimo di tentativi per questo livello di difficoltà.
     *
     * @return numero massimo di tentativi.
     */

    public int getAttempts() {
        return attempts;
    }

    /**
     * Restituisce il punteggio associato a questo livello di difficoltà.
     *
     * @return punteggio associato.
     */

    public int getPoints() {
        return points;
    }
}
