package it.unipv.ingsfw.model;

import it.unipv.ingsfw.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che implementa il pattern Observable per gestire gli Observer.
 * Gli Observer possono registrarsi per ricevere notifiche quando avvengono determinati eventi.
 */

public class Observable {

    private List<Observer> observers;

    /**
     * Costruttore che inizializza la lista degli observer.
     */

    public Observable() {
        this.observers = new ArrayList<>();
    }

    /**
     * Aggiunge un observer alla lista degli observer registrati.
     *
     * @param observer l' observer da aggiungere.
     */

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Rimuove un observer dalla lista degli observer registrati.
     *
     * @param observer l' observer da rimuovere.
     */

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica tutti gli observer registrati con un nuovo suggerimento e il tentativo corrente.
     *
     * @param newHint l' array di int che rappresenta il nuovo suggerimento da notificare agli observer.
     * @param currentAttempt l'indice del tentativo corrente.
     */

    public void notifyObservers(int[] newHint, int currentAttempt) {
        for(Observer observer: observers) {
            observer.update(newHint, currentAttempt);
        }
    }

    /**
     * Notifica tutti gli observer registrati con l'identificatore del gioco, il nome del Decoder e i nuovi punti.
     *
     * @param id l'identificatore del gioco da notificare agli observer.
     * @param name il nome del Decoder da notificare agli observer.
     * @param newPoints i nuovi punti del Decoder da notificare agli observer.
     */

    public void notifyObservers(int id, String name, int newPoints) {
        for(Observer observer: observers) {
            observer.update(id, name, newPoints);
        }
    }

}
