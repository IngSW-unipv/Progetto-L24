package it.unipv.ingsfw.model;

public abstract class Player {

    private final String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public Player() {
        this.name = "Player1";
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
