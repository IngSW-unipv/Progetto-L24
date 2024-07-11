package it.unipv.ingsfw.view;   //definisce il package in cui si trova la classe wrongPosHeaderRenderer
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Componente dell'interfaccia collegato alla tabella di gioco adibito al render dell' header sinistro.
 */
public class wrongPosHeaderRenderer extends JLabel implements TableCellRenderer {
//    Costruttore:

    /**
     * Definizione delle proprietà grafiche del renderer.
     */
    public wrongPosHeaderRenderer() {

//        definizione e applicazione nuovo font
        setFont(new Font("Inconsolata", Font.BOLD, 20));
//        impostazione di allineamento centrato del testo
        setHorizontalAlignment(CENTER);
//        impostazione di opacità
        setOpaque(true);
//        impostazione colore di testo
        setForeground(Color.black);
//        impostazione colore di sfondo
        setBackground(new Color(0,190,255));
//        definizione e applicazione nuovo bordo
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Acquisizione del componente di cui è stato eseguito il render.
     * @param table           the <code>JTable</code> that is asking the
     *                          renderer to draw; can be <code>null</code>
     * @param value           the value of the cell to be rendered.  It is
     *                          up to the specific renderer to interpret
     *                          and draw the value.  For example, if
     *                          <code>value</code>
     *                          is the string "true", it could be rendered as a
     *                          string, or it could be rendered as a checkbox
     *                          that is checked.  <code>null</code> is a
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
     * @return
     * Il componente renderizzato.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        conversione valori numerici in stringhe
        setText(value.toString());
//        ritorno del renderer
        return this;
    }
}
