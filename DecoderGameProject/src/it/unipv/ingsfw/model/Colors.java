package it.unipv.ingsfw.model;   //Definisce il package in cui è contenuto l' enum Colors
// importazioni utili alla corretta definizione aspetti grafici
import java.awt.*;

/**
 * Elenco colori di gioco.
 */
public enum Colors {
//    Definizione costanti e loro proprietà

    ARANCIO("Arancio", Color.orange),

    GIALLO("Giallo", Color.yellow),

    VERDE("Verde",Color.green),

    BLU("Blu",Color.blue),

    ROSA("Rosa",Color.pink),

    NERO("Nero",Color.black);

//    Definizione costanti di proprietà

    private final String colorName;
    private final Color rgbColor;

//    Costruttore:

    Colors(String nome, Color colore) {

//        Inizializzazioni:

        this.colorName = nome;
        this.rgbColor = colore;
    }

    public String getColorName() {
        return colorName;
    }

    public Color getRgbColor() {
        return rgbColor;
    }

}
