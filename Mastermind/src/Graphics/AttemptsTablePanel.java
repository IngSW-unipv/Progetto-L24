package Graphics;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AttemptsTablePanel extends JPanel {

    protected AttemptTable attemptTable;
    private AttemptTableModel attemptTableModel;
    protected DefaultTableCellRenderer tableCellRenderer;
//    JTable table;

    public AttemptsTablePanel(int attempts) {

        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);
        Border border = BorderFactory.createLineBorder(Color.gray);
        setBorder(border);
        setLayout(new BorderLayout());

        attemptTableModel = new AttemptTableModel(attempts);
        tableCellRenderer = new DefaultTableCellRenderer();
        attemptTable = new AttemptTable(attemptTableModel);

//        table = new JTable(new TableModelAttempt(attempts));
        attemptTable.getTableHeader().setDefaultRenderer(new DefaultHeaderRenderer());

        attemptTable.getColumnModel().getColumn(0).setHeaderRenderer(new wrongPosHeaderRenderer());
        attemptTable.getColumnModel().getColumn(5).setHeaderRenderer(new rightPosHeaderRenderer());

        attemptTable.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
        attemptTable.getColumnModel().getColumn(5).setCellRenderer(tableCellRenderer);
        add(new JScrollPane(attemptTable), BorderLayout.CENTER);



    }

}
