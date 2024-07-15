package it.unipv.ingsfw.model;

import java.util.ArrayList;
import java.awt.Color;

/**
 * Interfaccia che definisce le operazioni necessarie per una strategia di encoding.
 * Le implementazioni di questa interfaccia sono responsabili di generare un codice segreto,
 * valutare una sequenza di tentativo e fornire il codice segreto generato.
 */

public interface EncoderStrategy {

    /**
     * Genera il codice segreto secondo la logica specifica dell'implementazione.
     */

    void generateSecretCode();

    /**
     * Genera il codice segreto secondo la lista di valori inserita come parametro.
     *
     * @param secretCode il codice segreto da inserire.
     */

    void setSecretCode(ArrayList<Color> secretCode);

    /**
     * Valuta una sequenza di tentativo rispetto al codice segreto generato.
     *
     * @param attemptSequence la sequenza di colori tentata.
     * @return un array di interi che rappresenta il risultato della valutazione:
     *         - il primo valore rappresenta il numero di colori corretti ma posizionati diversamente;
     *         - il secondo valore rappresenta il numero di colori corretti e posizionati correttamente.
     */

    int[] evaluateSequence(ArrayList<Color> attemptSequence);

    /**
     * Restituisce il codice segreto generato.
     *
     * @return una lista di colori che rappresenta il codice segreto.
     */

    ArrayList<Color> getSecretCode();

}
