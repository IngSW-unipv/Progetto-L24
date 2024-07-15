package it.unipv.ingsfw.view;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * Classe che rappresenta il modello per la tabella di gioco.
 * Estende la classe AbstractTableModel per gestire le caratteristiche della tabella associata.
 */
public class AttemptsTableModel extends AbstractTableModel {

//    numero di tentativi associato al numero di righe della tabella
    int attempts;
//    Array di stringhe che rappresentano le colonne della tabella con il rispettivo nome
    String[] columnNames = {"Pos. errata", "1°colore", "2°colore", "3°colore", "4°colore", "Pos. corretta"};
//    matrice colori inseriti
    private static Color[][] cellColors;
//    matrice valori indizi forniti
    private static int[][] hints;

    /**
     * Costruttore che inizializza le informazioni necessarie del modello.
     *
     * @param attempts Numero di tentativi totali disponibili al decoder.
     */
    public AttemptsTableModel(int attempts) {

        this.attempts = attempts;
        cellColors = new Color[attempts][4];
        hints = new int[attempts][2];
    }

    /**
     * Definisce il numero di colonne per il modello.
     *
     * @param column il numero di colonne per il modello.
     * @return elenco dei nomi delle colonne.
     */

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Acquisisce il numero di righe del modello.
     *
     * @return il numero di righe del modello.
     */

    @Override
    public int getRowCount() {
        return attempts;
    }

    /**
     * Acquisisce il numero di colonne del modello.
     *
     * @return il numero di colonne del modello.
     */

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Inserisce un valore passato nel modello nella cella definita da riga e colonna.
     *
     * @param aValue il valore da inserire nella cella del modello.
     * @param rowIndex il numero della riga della cella in cui inserire il valore.
     * @param columnIndex il numero della colonna della cella in cui inserire il valore.
     */
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

    /**
     * Acquisisce il valore nella cella individuata tramite i numeri di riga e colonna.
     *
     * @param rowIndex il numero della riga della cella da cui estrarre il valore.
     * @param columnIndex il numero della colonna della cella da cui estrarre il valore.
     * @return il valore estratto dalla cella individuata.
     */

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
     * Inserisce un colore passato nel modello nella cella definita da riga e colonna
     *
     * @param row Numero della riga della cella da colorare.
     * @param column Numero della colonna della cella da colorare.
     * @param color Colore per la cella.
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
     * Acquisisce il colore nella cella specificata dai numeri di riga e colonna.
     *
     * @param row Numero di riga della cella da cui estrarre il colore.
     * @param column Numero di colonna della cella da cui estrarre il colore.
     * @return Colore presente nella cella individuata.
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
}