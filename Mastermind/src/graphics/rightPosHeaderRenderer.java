package graphics;   //Definisce il package in cui si trova la classe rightPosHeaderRenderer
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class rightPosHeaderRenderer extends JLabel implements TableCellRenderer {
//    Costruttore:

    public rightPosHeaderRenderer() {
//        definizione e applicazione nuovo font
        setFont(new Font("Inconsolata", Font.BOLD, 20));

        setHorizontalAlignment(CENTER);


//        impostazione di opacità
        setOpaque(true);
//        impostazione colore di sfondo "verde brillante"
        setBackground(new Color(0,255,0));
//        definizione e applicazione nuovo bordo
        setBorder(BorderFactory.createEtchedBorder());
    }

//    metodo per acquisizione renderer
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        conversione valori numerici in stringhe
        setText(value.toString());
//        ritorno renderer
        return this;
    }
}
