package it.unipv.ingsfw.model;
import java.awt.*;

/**
 * Enum che rappresenta l'elenco completo dei colori di gioco.
 * Ogni colore presenta il proprio nome e la sua rappresentazione RGB.
 */
public enum Colors {

    /**
     * Colore ARANCIO:
     * - Nome stringa Arancio.
     * - Colore in libreria orange.
     */

    ARANCIO("Arancio", Color.orange),

    /**
     * Colore GIALLO:
     * - Nome stringa Giallo.
     * - Colore in libreria yellow.
     */

    GIALLO("Giallo", Color.yellow),

    /**
     * Colore VERDE:
     * - Nome stringa Verde.
     * - Colore in libreria green.
     */

    VERDE("Verde",Color.green),

    /**
     * Colore BLU:
     * - Nome stringa Blu.
     * - Colore in libreria blue.
     */

    BLU("Blu",Color.blue),

    /**
     * Colore ROSA:
     * - Nome stringa Rosa.
     * - Colore in libreria pink.
     */

    ROSA("Rosa",Color.pink),

    /**
     * Colore NERO:
     * - Nome stringa Nero.
     * - Colore in libreria black.
     */

    NERO("Nero",Color.black);

    private final String colorName;
    private final Color rgbColor;

    /**
     * Costruttore privato per l' enum Colors.
     *
     * @param nome nome del colore in stringa.
     * @param colore valore RGB del colore in base ai dati di libreria.
     */

    Colors(String nome, Color colore) {

//        Inizializzazioni:

        this.colorName = nome;
        this.rgbColor = colore;
    }

    /**
     * Restituisce il nome del colore scelto.
     *
     * @return nome del colore.
     */

    public String getColorName() {
        return colorName;
    }

    /**
     * Restituisce il valore RGB del colore scelto.
     *
     * @return oggetto RGB del colore.
     */

    public Color getRgbColor() {
        return rgbColor;
    }

}
