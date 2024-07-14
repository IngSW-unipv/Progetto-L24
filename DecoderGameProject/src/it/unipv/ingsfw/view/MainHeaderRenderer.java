package it.unipv.ingsfw.view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Classe che rappresenta il renderer principale per la tabella di gioco.
 * Estende JLabel per gestire le proprietà del testo nel header.
 * Implementa TableCellRenderer per gestire l'acquisizione del componente da renderizzare.
 */

public class MainHeaderRenderer extends JLabel implements TableCellRenderer {

    /**
     * Costruttore che definisce le proprietà grafiche del renderer.
     */

    public MainHeaderRenderer() {
//        definizione e applicazione nuovo font header
        setFont(new Font("Inconsolata", Font.BOLD, 20));
//        impostazione di allineamento centrato del testo
        setHorizontalAlignment(CENTER);
//        impostazione opacità
        setOpaque(true);
//        impostazione colore testo "bianco"
        setForeground(Color.white);
//        impostazione colore di sfondo "nero"
        setBackground(Color.darkGray);
//        definizione e applicazione nuovo bordo
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Metodo per l'acquisizione del componente di cui è stato eseguito il render.
     * @param table           the <code>JTable</code> that is asking the
     *                          renderer to draw; can be <code>null</code>
     * @param value           the value of the cell to be rendered.  It is
     *                          up to the specific renderer to interpret
     *                          and draw the value.  For example, if
     *                          <code>value</code>
     *                          is the string "true", it could be rendered as a
     *                          string, or it could be rendered as a check
     *                          -box that is checked.  <code>null</code> is a
     *                          valid value
     * @param isSelected      true if the cell is to be rendered with the
     *                          selection highlighted; otherwise false
     * @param hasFocus        if true, render cell appropriately.  For
     *                          example, put a special border on the cell, if
     *                          the cell can be edited, render in the color used
     *                          to indicate editing
     * @param row             the row index of the cell being drawn.  When
     *                          drawing the header, the value of
     *                          <code>row</code> is -1
     * @param column          the column index of the cell being drawn
     *
     * @return il componente renderizzato.
     */

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
//        conversione valori numerici in stringhe
        setText(value.toString());
//        ritorno del renderer
        return this;
    }
}
