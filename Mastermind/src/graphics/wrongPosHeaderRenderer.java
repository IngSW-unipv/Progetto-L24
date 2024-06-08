package graphics;   //definisce il package in cui si trova la classe wrongPosHeaderRenderer
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class wrongPosHeaderRenderer extends JLabel implements TableCellRenderer {
//    Costruttore:

    public wrongPosHeaderRenderer() {

//        definizione e applicazione nuovo font
        setFont(new Font("Inconsolata", Font.BOLD, 20));
//        impostazione di allineamento centrato del testo
        setHorizontalAlignment(CENTER);
//        impostazione di opacità
        setOpaque(true);
//        impostazione colore di testo
        setForeground(Color.black);
//        impostazione colore di sfondo
        setBackground(new Color(0,190,255));
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
