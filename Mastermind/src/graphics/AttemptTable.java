package graphics;   //Definisce il package in cui è contenuta la classe AttemptTable

// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import java.awt.*;

/**
 * Componente tabellare dell'interfaccia di gioco.
 */
public class AttemptTable extends JTable {
//    Dichiarazioni:

    /**
     * Definizione popup di fine gioco.
     */
    EndGamePopup popup;

//    Costruttore:

    /**
     * Definisce le caratteristiche grafiche della tabella di gioco e del popup collegato.
     * @param attemptTableModel
     * Modello della tabella di gioco contenente le impostazioni della stessa.
     */
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
