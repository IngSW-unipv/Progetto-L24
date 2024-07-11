package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int[] newHint, int currentAttempt) {
        for(Observer observer: observers) {
            observer.update(newHint, currentAttempt);
        }
    }

}
