package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AttemptsTablePanel extends JPanel {

    protected AttemptTable attemptTable;
    private AttemptTableModel attemptTableModel;
//    JTable table;

    public AttemptsTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);
        Border border = BorderFactory.createLineBorder(Color.gray);
        setBorder(border);
        setLayout(new BorderLayout());

        attemptTableModel = new AttemptTableModel(attempts);
        attemptTable = new AttemptTable(attemptTableModel);

//        table = new JTable(new TableModelAttempt(attempts));
        attemptTable.getTableHeader().setDefaultRenderer(new DefaultHeaderRenderer());
        attemptTable.getColumnModel().getColumn(0).setHeaderRenderer(new RedKeyPolesHeaderRenderer());
        attemptTable.getColumnModel().getColumn(5).setHeaderRenderer(new WhiteKeyPolesHeaderRenderer());
        attemptTable.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
        attemptTable.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer());
        add(new JScrollPane(attemptTable), BorderLayout.CENTER);



    }

}
