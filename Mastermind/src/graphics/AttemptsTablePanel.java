package graphics;   //Definisce il Package in cui è contenuta la classe AttemptTablePanel

//Serie di importazioni per la corretta gestione dell'interfaccia grafica
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *  Pannello principale contenente la tabella di gioco.
 */
public class AttemptsTablePanel extends JPanel {


    /**
     * Definizione tabella di gioco.
     */
    private final AttemptTable attemptTable;

    /**
     * Definizione modello tabella di gioco.
     */
    private final AttemptTableModel attemptTableModel;

//    Costruttore:

    /**
     * Definisce le impostazioni di visualizzazione dei contenuti nel pannello e le sue proprietà.
     * @param attempts
     * Numero totale di tentativi disponibili al giocatore. Rappresenta il numero di righe della tabella.
     */
    public AttemptsTablePanel(int attempts) {

//        definizione dimensioni pannello
        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);
//        creazione nuovo bordo
        Border border = BorderFactory.createLineBorder(Color.gray);
//        applicazione nuovo bordo al pannello
        setBorder(border);
//        definizione nuovo layout pannello
        setLayout(new BorderLayout());

//        Inizializzazioni:

        attemptTableModel = new AttemptTableModel(attempts);
        attemptTable = new AttemptTable(attemptTableModel);

//        applicazione nuovo renderer per header
        attemptTable.getTableHeader().setDefaultRenderer(new MainHeaderRenderer());

//        applicazione speciali nuovi renderer per colonne 0 e 5
        attemptTable.getColumnModel().getColumn(0).setHeaderRenderer(new wrongPosHeaderRenderer());
        attemptTable.getColumnModel().getColumn(5).setHeaderRenderer(new rightPosHeaderRenderer());

//        aggiunta tabella al pannello
        add(new JScrollPane(attemptTable), BorderLayout.CENTER);

    }

    /**
     * Acquisizione tabella dal pannello.
     * @return
     * Interfaccia principale di gioco costituita da una tabella.
     */
    public AttemptTable getAttemptTable() {
        return attemptTable;
    }

    /**
     * Acquisizione modello della tabella con relative impostazioni.
     * @return
     * Pacchetto di impostazioni specifiche per la tabella di gioco.
     */
    @SuppressWarnings("unused")
    public AttemptTableModel getAttemptTableModel() {
        return attemptTableModel;
    }
}
