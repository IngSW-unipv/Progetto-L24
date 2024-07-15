package it.unipv.ingsfw.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Implementazione dell'interfaccia EncoderStrategy che genera un codice segreto automaticamente.
 * Il codice segreto è una sequenza di quattro colori non ripetuti scelti casualmente.
 */

public class AutoEncoder implements EncoderStrategy {

    private final ArrayList<Color> secretCode;

    /**
     * Costruttore della classe AutoEncoder.
     * Inizializza l'oggetto creando un'istanza vuota per il codice segreto.
     */

    public AutoEncoder() {
        this.secretCode = new ArrayList<>();
    }

    /**
     * Genera un nuovo codice segreto scelto casualmente.
     */

    @Override
    public void generateSecretCode() {
//        Reset del codice segreto
        secretCode.clear();
//        Definizione nuovo stream di valori pseudocasuali
        Random random = new Random();
//        Variabile locale che conterrà il colore generato
        Color color;
//        ciclo per la generazione di un colore tra quelli predefiniti
        for(int i = 0; i < 4; i++) {
            do {
                color = Colors.values()[random.nextInt(Colors.values().length)].getRgbColor();
//                Ripetizione della generazione in caso di colori uguali
            } while (secretCode.contains(color));
//            Salvataggio del colore nel codice segreto
            secretCode.add(color);
        }
    }

    /**
     * Valuta una sequenza rispetto al codice segreto.
     *
     * @param attemptSequence la sequenza di colori tentata.
     * @return un array di interi contenente due valori:
     *         - il primo valore rappresenta il numero di colori corretti ma posizionati diversamente;
     *         - il secondo valore rappresenta il numero di colori corretti e posizionati correttamente.
     * @throws RuntimeException se il codice segreto o la sequenza di tentativo non sono validi.
     */

    @Override
    public int[] evaluateSequence(ArrayList<Color> attemptSequence) {
        if (attemptSequence != null) {
//            Variabile locale che ospiterà l'indizio calcolato
            int[] hint = new int[2];
//            ciclo esterno per l'analisi di eventuali uguaglianze nella stessa posizione
            for(int i = 0; i < attemptSequence.size(); i++) {
                if(attemptSequence.get(i).equals(secretCode.get(i))) {
                    hint[1] += 1;
                }
                else {
//                    Ciclo interno per l'analisi di eventuali uguaglianze in posizioni diverse
                    for(int j = 0; j < attemptSequence.size(); j++) {
                        if(j != i && attemptSequence.get(i).equals(secretCode.get(j))) {
                            hint[0] += 1;
                        }
                    }
                }
            }
            return hint;
        }
        else {
            throw new RuntimeException("Secret code or sequence given not valid");
        }
    }

    /**
     * Inserisce il codice segreto definito tramite la lista passata
     * come parametro.
     *
     * @param secretCode la lista di valori da inserire nel codice segreto.
     */

    @Override
    public void setSecretCode(ArrayList<Color> secretCode) {
        this.secretCode.clear();
        this.secretCode.addAll(secretCode);
    }

    /**
     * Restituisce il codice segreto attualmente generato.
     *
     * @return lista di colori che rappresenta il codice segreto.
     */

    public ArrayList<Color> getSecretCode() {
        return secretCode;
    }
}
