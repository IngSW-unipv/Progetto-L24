package it.unipv.ingsfw.view;   //Definisce il package in cui è contenuta la classe AttemptTableCellRenderer
// importazioni utili alla corretta definizione aspetti grafici

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Componente dell'interfaccia a supporto della tabella di gioco per il render delle celle.
 */
public class AttemptsTableCellRenderer extends DefaultTableCellRenderer {

    /**
     * Operazioni di definizione del comportamento del renderer delle celle.
     * @param table  the <code>JTable</code>
     * @param value  the value to assign to the cell at
     *                  <code>[row, column]</code>
     * @param isSelected true if cell is selected
     * @param hasFocus true if cell has focus
     * @param row  the row of the cell to render
     * @param column the column of the cell to render
     * @return
     * Componente della tabella di cui è stato eseguito il render.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        definizione e inizializzazione componente di base del renderer
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        definizione e inizializzazione variabile colore utile alla colorazione delle celle
        Color cellColor = AttemptsTableModel.getCellColor(row, column);
//        verifica presenza nuovo colore per cella
        if (cellColor != null) {
//            applicazione nuovo colore allo sfondo della cella
            cellComponent.setBackground(cellColor);

        } else {
//            in caso di assenza nuovo colore ri-colorazione altre celle con lo stesso colore
            cellComponent.setBackground(table.getBackground());
        }
//        ritorno del componente di base per il render
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    }
}
