package Graphics;   //Definisce il Package in cui è contenuta la classe AttemptTablePanel

//Serie di importazioni per la corretta gestione dell'interfaccia grafica
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AttemptsTablePanel extends JPanel {

//    Definizioni:

//    tabella di gioco
    private final AttemptTable attemptTable;
//    modello della tabella di gioco
    private final AttemptTableModel attemptTableModel;

//    Costruttore:

//    parametro attempts per definizione numero righe tabella
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

    public AttemptTable getAttemptTable() {
        return attemptTable;
    }
    @SuppressWarnings("unused")
    public AttemptTableModel getAttemptTableModel() {
        return attemptTableModel;
    }

}
