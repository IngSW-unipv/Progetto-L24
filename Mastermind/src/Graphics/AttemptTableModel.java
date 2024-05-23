package Graphics;   //Definisce il package in cui è contenuta la classe AttemptTableModel
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class AttemptTableModel extends AbstractTableModel {
//    Definizioni:

//    numero totale tentativi
    int attempts;
//    nomi colonne tabella
    String[] columnNames = {"Pos. errata", "1°colore", "2°colore", "3°colore", "4°colore", "Pos. corretta"};
//    matrice colori inseriti
    private static Color[][] cellColors;
//    matrice valori indizi forniti
    private static int[][] hints;

//    Costruttore:

    public AttemptTableModel(int attempts) {
//        Inizializzazioni:

        this.attempts = attempts;
        cellColors = new Color[attempts][4];
        hints = new int[attempts][2];
    }

//    metodo sovrascritto per acquisizione nomi colonne
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

//    metodo sovrascritto per acquisizione numero totale righe
    @Override
    public int getRowCount() {
        return attempts;
    }

//    metodo sovrascritto per acquisizione numero totale colonne
    @Override
    public int getColumnCount() {
        return 6;
    }

//    metodo sovrascritto per inserimento valore in cella specifica
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        verifica correttezza numero colonne per indizi
        if(columnIndex == 5) {
//            salvataggio valore indizio "posizione corretta" nella matrice
            hints[rowIndex][1] = (int) aValue;
//            update tabella con nuovo valore
            fireTableCellUpdated(rowIndex,columnIndex);
        } else if (columnIndex == 0) {
//            salvataggio valore indizio "posizione errata" nella matrice
            hints[rowIndex][columnIndex] = (int) aValue;
//            update tabella con nuovo valore
            fireTableCellUpdated(rowIndex,columnIndex);
        }
    }

//    metodo per l'acquisizione di un valore indizio dalla matrice
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        verifica correttezza numero colonne per indizi
        if(columnIndex == 5) {
//            ritorno valore "posizione corretta" da matrice
            return hints[rowIndex][1];
        } else if (columnIndex == 0) {
//            ritorno valore "posizione errata" da matrice
            return hints[rowIndex][columnIndex];
        } else {
//            ritorno nullo per altre colonne
            return "";
        }
    }

//    metodo per inserimento nuovo colore in matrice colori
     public void setCellColor(int row, int column, Color color) {
//         salvataggio nuovo colore in matrice colori
        cellColors[row][column-1] = color;
//        update tabella con nuovo colore
        fireTableCellUpdated(row, column);
    }

//    metodo per l'acquisizione colore salvato in matrice
    public static Color getCellColor(int row, int column) {
//        verifica correttezza colonne colori
        if(column != 0 && column != 5) {
//            ritorno colore da matrice
            return cellColors[row][column-1];
        }
        else {
//            ritorno colore bianco in caso di errata colonna
            return Color.white;
        }
    }
}