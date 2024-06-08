package graphics;   //Definisce il package in cui è contenuta la classe AttemptTable
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

public class AttemptTable extends JTable {
//    Dichiarazioni:

//    popup di fine partita
    EndGamePopup popup;

//    Costruttore:


    public AttemptTable(AttemptTableModel attemptTableModel) {
//        Inizializzazioni:

        super(attemptTableModel);
        AttemptTableCellRenderer attemptTableCellRenderer = new AttemptTableCellRenderer();
        popup = new EndGamePopup();
//        allineamento testo visualizzato attraverso il CellRenderer
        attemptTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//        applicazione renderer alla tabella
        this.setDefaultRenderer(Object.class, attemptTableCellRenderer);
//        disabilitazione selezione celle
        setCellSelectionEnabled(false);
//        impostazione di altezza celle
        setRowHeight(57);
//        creazione e applicazione nuovo bordo
        this.setBorder(BorderFactory.createRaisedBevelBorder());
//        creazione nuovo font per testo visualizzato
        setFont(new Font("Inconsolata", Font.BOLD, 16));
    }
}
