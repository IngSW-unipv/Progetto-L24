package graphics;   //Definisce il package in cui è contenuto l' enum Colors
// importazioni utili alla corretta definizione aspetti grafici
import java.awt.*;

/**
 * Elenco colori di gioco.
 */
public enum Colors {
//    Definizione costanti e loro proprietà
    /**
     * Colore arancione sostitutivo al piolo codice dello stesso colore.
     */
    ARANCIO("Arancio", Color.orange),
    /**
     * Colore giallo sostitutivo al piolo codice dello stesso colore.
     */
    GIALLO("Giallo", Color.yellow),
    /**
     * Colore verde sostitutivo al piolo codice dello stesso colore.
     */
    VERDE("Verde",Color.green),
    /**
     * Colore blu sostitutivo al piolo codice dello stesso colore.
     */
    BLU("Blu",Color.blue),
    /**
     * Colore rosa sostitutivo al piolo codice dello stesso colore.
     */
    ROSA("Rosa",Color.pink),
    /**
     * Colore nero sostitutivo al piolo codice dello stesso colore.
     */
    NERO("Nero",Color.black);

//    Definizione costanti di proprietà

    private final String nomeColore;
    private final Color coloreRGB;

//    Costruttore:

    Colors(String nome, Color colore) {

//        Inizializzazioni:

        this.nomeColore = nome;
        this.coloreRGB = colore;
    }

    /**
     * Acquisizione del nome del colore.
     * @return
     * Stringa con il nome del colore.
     */
    public String getNomeColore() {
        return nomeColore;
    }

    /**
     * Acquisizione della tinta relativa al piolo codice.
     * @return
     * L'oggetto relativo al piolo codice.
     */
    public Color getColoreRGB() {
        return coloreRGB;
    }
}
