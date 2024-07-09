package it.unipv.ingsfw.view;   //Definisce il package in cui è contenuta la classe AttemptTable

// importazioni utili alla corretta definizione aspetti grafici

import javax.swing.*;
import java.awt.*;

/**
 * Componente tabellare dell'interfaccia di gioco.
 */
public class AttemptsTable extends JTable {
//    Dichiarazioni:


//    Costruttore:

    /**
     * Definisce le caratteristiche grafiche della tabella di gioco e del popup collegato.
     * @param attemptTableModel
     * Modello della tabella di gioco contenente le impostazioni della stessa.
     */
    public AttemptsTable(AttemptsTableModel attemptTableModel) {
//        Inizializzazioni:

        super(attemptTableModel);
        AttemptsTableCellRenderer attemptsTableCellRenderer = new AttemptsTableCellRenderer();
//        allineamento testo visualizzato attraverso il CellRenderer
        attemptsTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//        applicazione renderer alla tabella
        this.setDefaultRenderer(Object.class, attemptsTableCellRenderer);
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
