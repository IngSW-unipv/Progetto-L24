package it.unipv.ingsfw.view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe che rappresenta una tabella di gioco.
 * Estende la classe JTable per gestire le operazioni grafiche di definizione
 * e aggiornamento dei componenti.
 */
public class AttemptsTable extends JTable {

    /**
     * Costruttore che definisce le caratteristiche grafiche della tabella di gioco.
     *
     * @param attemptTableModel Modello della tabella di gioco contenente le impostazioni della stessa.
     */
    public AttemptsTable(AttemptsTableModel attemptTableModel) {

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

    /**
     * Acquisisce il modello della tabella.
     *
     * @return il modello corrente della tabella.
     */

    public AttemptsTableModel getModel() {
        return (AttemptsTableModel) super.getModel();
    }
}
