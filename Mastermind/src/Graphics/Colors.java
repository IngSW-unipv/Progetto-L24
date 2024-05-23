package Graphics;   //Definisce il package in cui è contenuto l' enum Colors
// importazioni utili alla corretta definizione aspetti grafici
import java.awt.*;

public enum Colors {
//    Definizione costanti e loro proprietà

    ARANCIO("Arancio", Color.orange),
    GIALLO("Giallo", Color.yellow),
    VERDE("Verde",Color.green),
    BLU("Blu",Color.blue),
    ROSA("Rosa",Color.pink),
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

//    metodo per il richiamo della proprietà "nome"
    public String getNomeColore() {
        return nomeColore;
    }

//    metodo per il richiamo della proprietà "colore"
    public Color getColoreRGB() {
        return coloreRGB;
    }
}
