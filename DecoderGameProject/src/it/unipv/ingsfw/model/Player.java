package it.unipv.ingsfw.model;

public abstract class Player extends Observable {

    private String name;
    private int points;

    public Player(String name) {
        super();
        this.name = name;
        this.points = 0;
    }

    public Player() {
        super();
        this.name = "Player1";
        this.points = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

}
