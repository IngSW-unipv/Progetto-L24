package graphics;   //Definisce il package in cui è contenuta l'interfaccia AttemptListener

/**
 * Interfaccia controller tra OptionBar e MainGUi.
 */
public interface AttemptsListener {


/**
 * Definizione e trasporto del nuovo numero di tentativi a disposizione del giocatore.
 *
 * @param attempts Numero di tentativi a disposizione del giocatore.
 */
    void difficultyChoose(int attempts);
}
