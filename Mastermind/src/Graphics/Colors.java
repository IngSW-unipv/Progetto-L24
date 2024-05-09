package Graphics;

import java.awt.*;

public enum Colors {

    ARANCIO("Arancio", Color.orange),
    GIALLO("Giallo", Color.yellow),
    VERDE("Verde",Color.green),
    BLU("Blu",Color.blue),
    ROSA("Rosa",Color.pink),
    NERO("Nero",Color.black);

    private String nomeColore;
    private Color coloreRGB;

    private Colors(String nome, Color colore) {
        this.nomeColore = nome;
        this.coloreRGB = colore;
    }

    public String getNomeColore() {
        return nomeColore;
    }
    public Color getColoreRGB() {
        return coloreRGB;
    }

}
