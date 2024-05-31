package graphics;   //Definisce il package in cui si trova la classe MainHeaderRenderer
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainHeaderRenderer extends JLabel implements TableCellRenderer {
//    Costruttore:

    public MainHeaderRenderer() {
//        definizione e applicazione nuovo font header
        setFont(new Font("Inconsolata", Font.BOLD, 20));

        setHorizontalAlignment(CENTER);


//        impostazione opacità
        setOpaque(true);
//        impostazione colore testo "bianco"
        setForeground(Color.white);
//        impostazione colore di sfondo "nero"
        setBackground(Color.darkGray);
//        definizione e applicazione nuovo bordo
        setBorder(BorderFactory.createEtchedBorder());
    }

//    metodo per acquisizione renderer
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        conversione valori numerici in stringhe
        setText(value.toString());
//        ritorno del renderer
        return this;
    }
}
