package graphics;   //Definisce il package in cui è contenuta la classe AttemptTableCellRenderer
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AttemptTableCellRenderer extends DefaultTableCellRenderer {

//    metodo sovrascritto per la definizione delle operazioni di render sulle celle
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        definizione e inizializzazione componente di base del renderer
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        definizione e inizializzazione variabile colore utile alla colorazione delle celle
        Color cellColor = AttemptTableModel.getCellColor(row, column);
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
