package it.unipv.ingsfw.model;

public enum Difficulty {

    EASY(15),

    NORMAL(10),

    HARD(5);

    private final int attempts;

    Difficulty(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

}
