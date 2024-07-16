package it.unipv.ingsfw.model;

import it.unipv.ingsfw.Observer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Fornisce un'interfaccia semplificata per interagire con le entità del gioco,
 * inclusi encoder, decoder e le partite.
 */

public class GameFacade {

    private static GameFacade instance;
    private Encoder encoder;
    private Decoder decoder;
    private Game game;
    private int attemptsLeft;
    private final String[] colorList;
    private final GameEntitiesFactory factory;

    /**
     * Costruttore privato per inizializzare una singola istanza di GameFacade.
     * Utilizza ConcreteGameEntitiesFactory per creare nuove istanze di entità di gioco.
     * Inizializza la lista dei nomi dei colori disponibili per il gioco.
     */

    private GameFacade() {
        this.factory = new ConcreteGameEntitiesFactory();
        colorList = new String[Colors.values().length];
        for(int i = 0; i < Colors.values().length; i++) {
            colorList[i] = Colors.values()[i].getColorName();
        }
//        System.out.println("Model is ready!");
    }

    /**
     * Restituisce l'istanza singleton di GameFacade.
     *
     * @return l'istanza singleton di GameFacade.
     */

    public static GameFacade getInstance() {
        if(instance  == null) {
            instance = new GameFacade();
        }
        return instance;
    }

    /**
     * Crea un nuovo encoder con il nome specificato, una strategia di encoding e un observer.
     *
     * @param encoderName nome dell' encoder da creare.
     * @param strategy strategia di encoding da associare all' encoder.
     * @param observer observer da registrare sull' encoder.
     */

    public void createNewEncoder(String encoderName, EncoderStrategy strategy, Observer observer) {
        this.encoder = factory.createEncoder(encoderName);
        this.encoder.setStrategy(strategy);
        this.encoder.addObserver(observer);
    }

    /**
     * Crea un nuovo decoder con il nome specificato e un observer.
     *
     * @param decoderName nome del decoder da creare.
     * @param observer observer da registrare sul decoder.
     */

    public void createNewDecoder(String decoderName, Observer observer) {
        this.decoder = factory.createDecoder(decoderName);
        this.decoder.addObserver(observer);
    }

    /**
     * Crea una nuova partita con l'ID specificato.
     *
     * @param id ID della nuova partita.
     */

    public void createNewGame(int id) {
        this.game = factory.createGame();
        game.setId(id);
    }

    /**
     * Genera un nuovo codice segreto utilizzando la strategia definita.
     */

    public void generateSecretCode() {
        this.encoder.generateSecretCode();
    }

    /**
     * Acquisisce dal decoder locale il nome.
     *
     * @return il nome del decoder.
     */

    public String getDecoderName() {
        return this.encoder.getName();
    }

    /**
     * Acquisisce dal decoder locale i punti.
     *
     * @return il punteggio odierno del decoder.
     */

    public int getDecoderPoints() {
        return this.decoder.getPoints();
    }

    /**
     * Imposta il decoder per la partita corrente.
     *
     * @param decoder decoder da impostare.
     */

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    /**
     * Imposta l' encoder per la partita corrente.
     *
     * @param encoder encoder da impostare.
     */

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    /**
     * Restituisce l' encoder associato alla partita corrente.
     *
     * @return l'encoder associato alla partita.
     */

    public Encoder getEncoder() {
        return encoder;
    }

    /**
     * Restituisce il decoder associato alla partita corrente.
     *
     * @return il decoder associato alla partita.
     */

    public Decoder getDecoder() {
        return decoder;
    }

    /**
     * Restituisce l'oggetto Game associato alla partita corrente.
     *
     * @return l'oggetto Game associato alla partita.
     */

    public Game getGame() {
        return game;
    }

    /**
     * Restituisce la lista dei nomi dei colori disponibili per il gioco.
     *
     * @return la lista dei nomi dei colori.
     */

    public String[] getColorList() {
        return colorList;
    }

    /**
     * Inizializza il numero di tentativi rimanenti alla quantità totale di tentativi della partita.
     */

    public void initializeAttemptsLeft() {
        this.attemptsLeft = game.getTotAttempts();
    }

    /**
     * Restituisce il numero di tentativi rimanenti nella partita.
     *
     * @return il numero di tentativi rimanenti.
     */

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Modifica lo stato del gioco in "Started".
     */

    public void startGame() {
        this.game.start();
    }

    /**
     * Modifica lo stato del gioco in "Ended".
     */

    public void endGame() {
        this.game.end();
    }

    /**
     * Acquisisce lo stato attuale del gioco.
     *
     * @return lo stato del gioco.
     */

    public String getGameState() {
        return this.game.getState();
    }

    /**
     * Acquisisce l'ID del gioco attuale.
     *
     * @return l'ID del gioco.
     */

    public int getThisGameId() {
        return this.game.getId();
    }

    /**
     * Acquisisce il numero totale di tentativi per il gioco corrente.
     *
     * @return il numero totale di tentativi.
     */

    public int getThisGameTotalAttempts() {
        return this.game.getTotAttempts();
    }

    /**
     * Acquisisce il numero di tentativi effettuati per il gioco corrente.
     *
     * @return il numero di tentativi effettuati.
     */

    public int getThisGameAttemptsPlayed() {
        return this.game.getAttemptPlayed();
    }

    /**
     * Verifica se ci sono ancora tentativi rimanenti nella partita.
     *
     * @return true se ci sono tentativi rimanenti, false altrimenti.
     */

    public boolean hasAttemptsLeft() {
        return attemptsLeft > 0;
    }

    /**
     * Verifica se il giocatore ha vinto la partita, controllando l'ultimo suggerimento.
     *
     * @return true se il giocatore ha vinto, false altrimenti.
     */

    public boolean checkWinHint() {
        return this.game.getLastHint()[1] == 4;
    }

    /**
     * Gestisce un turno di gioco, aggiungendo la sequenza di tentativo, valutando il risultato
     * e notificando gli observer.
     *
     * @param sequence la sequenza di colori del tentativo.
     */

    public void playTurn(ArrayList<Color> sequence) {
        this.game.addSequence(sequence);
        int[] hint = this.encoder.evaluateSequence(sequence);
//        System.out.println(hint[0] + " " + hint[1]);
        this.game.addHint(hint);
        this.encoder.notifyObservers(hint, this.game.getAttemptPlayed());
    }

    /**
     * Conclude il turno di gioco aggiornando il numero di tentativi effettuati e i tentativi rimanenti.
     */

    public void endTurn() {
        this.game.setAttemptPlayed(this.game.getAttemptPlayed() + 1);
        this.attemptsLeft -= 1;
    }

    /**
     * Gestisce la vittoria della partita, incrementando i punti del decoder in base alla difficoltà della partita.
     * Notifica gli observer del decoder con l'ID della partita, il nome del decoder e i punti aggiornati.
     */

    public void winGame() {
        for(int i = 0; i < Difficulty.values().length; i++) {
            if(Difficulty.values()[i].getAttempts() == this.game.getTotAttempts()) {
                this.decoder.setPoints(this.decoder.getPoints() + Difficulty.values()[i].getPoints());
            }
        }
        this.decoder.notifyObservers(this.game.getId(), this.decoder.getName(), this.decoder.getPoints());
    }

    /**
     * Gestisce la sconfitta della partita, incrementando i punti dell' encoder.
     */

    public void looseGame() {
        this.encoder.setPoints(this.encoder.getPoints() + 1);
    }

    /**
     * Converte il codice segreto dell' encoder in una lista di nomi di colori leggibili.
     *
     * @return una lista di nomi di colori corrispondenti al codice segreto dell' encoder.
     */

    public ArrayList<String> convertSecretCodeToString() {
        ArrayList<String> colorList = new ArrayList<>();
        for(Color color: encoder.getSecretCode()) {
            for(int i = 0; i < Colors.values().length; i++) {
                if(color.equals(Colors.values()[i].getRgbColor())) {
                    colorList.add(Colors.values()[i].getColorName());
                }
            }
        }
        return colorList;
    }
}
