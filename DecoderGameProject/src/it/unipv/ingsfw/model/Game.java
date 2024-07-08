package it.unipv.ingsfw.model;

public class Game {

    private int id;
    private String state;

    public Game() {
        this.state = "Not started";
    }

    public void start() {
        this.state = "started";
    }

    public void end() {
        this.state = "ended";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }
}
