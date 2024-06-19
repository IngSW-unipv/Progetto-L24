package graphics;   //Definisce il package in cui è contenuta la classe AttemptTableModel
// importazioni utili alla corretta definizione aspetti grafici
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * Componente dell'interfaccia collegato alla tabella di gioco che ne definisce la struttura e i comportamenti.
 */
public class AttemptTableModel extends AbstractTableModel {
//    Definizioni:

    /**
     * Definizione numero totale di tentativi.
     */
    int attempts;
    /**
     * Definizione dei titoli relativi alle colonne della tabella di gioco.
     */
    String[] columnNames = {"Pos. errata", "1°colore", "2°colore", "3°colore", "4°colore", "Pos. corretta"};
//    matrice colori inseriti
    private static Color[][] cellColors;
//    matrice valori indizi forniti
    private static int[][] hints;

//    Costruttore:

    /**
     * Inizializza le informazioni necessarie alla tabella per funzionare correttamente.
     * @param attempts
     * Numero di tentativi totali disponibili al giocatore.
     */
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
        return columnNames.length;
    }

//    metodo sovrascritto per inserimento valore in cella specifica
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        verifica riga presente e valori nell'intervallo corretto
        if((rowIndex >= 0) && (rowIndex < attempts) && ((int)aValue >= 0) && ((int)aValue < 5)) {
//        verifica correttezza numero colonne per indizi
            if (columnIndex == 5) {
//            salvataggio valore indizio "posizione corretta" nella matrice
                hints[rowIndex][1] = (int) aValue;
//            update tabella con nuovo valore
                fireTableCellUpdated(rowIndex, columnIndex);
            } else if (columnIndex == 0) {
//            salvataggio valore indizio "posizione errata" nella matrice
                hints[rowIndex][columnIndex] = (int) aValue;
//            update tabella con nuovo valore
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        }
    }

//    metodo per l'acquisizione di un valore indizio dalla matrice
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex >= 0 && rowIndex < attempts) {
//        verifica correttezza numero colonne per indizi
            if (columnIndex == 5) {
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
        else {
            return "";
        }
    }

    /**
     * Impostazione del colore specificato tra i parametri nella cella individuata
     * dalle coordinate passate come parametri.
     * @param row
     * Numero della riga della cella da colorare.
     * @param column
     * Numero della colonna della cella da colorare.
     * @param color
     * Colore per la cella.
     */
     public void setCellColor(int row, int column, Color color) {
        if(row >= 0 && row < attempts && column > 0 && column < 5) {
//         salvataggio nuovo colore in matrice colori
            cellColors[row][column - 1] = color;
//        update tabella con nuovo colore
            fireTableCellUpdated(row, column);
        }
    }

    /**
     * Acquisizione del colore nella cella specificata dalle coordinate passate come parametri.
     * @param row
     * Numero di riga della cella da cui estrarre il colore.
     * @param column
     * Numero di colonna della cella da cui estrarre il colore.
     * @return
     * Colore presente nella cella individuata.
     */
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

    /**
     *Acquisizione della matrice dei colori della tabella di gioco.
     * @return
     * Matrice di colori.
     */
    public Color[][] getCellColors() {
        return cellColors;
    }

    /**
     * Acquisizione della matrice degli indizi di gioco.
     * @return
     * Matrice degli indizi.
     */
    public int[][] getHints() {
        return hints;
    }
}