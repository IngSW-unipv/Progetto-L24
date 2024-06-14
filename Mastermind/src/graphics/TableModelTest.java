package graphics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TableModelTest {

    private AttemptTableModel[] tableModel;

    @BeforeEach
    public void setUp() {
        tableModel = new AttemptTableModel[2];
        tableModel[0] = new AttemptTableModel(0);
    }

    @Test
    public void modelTest() {
//        caso limite "attempts = 0"

//        vettore nomi colonne
        assertNotNull(tableModel[0].columnNames,
                "il vettore delle colonne del modello non dovrebbe essere null");
        assertEquals(6,
                tableModel[0].columnNames.length,
                "il numero di colonne del modello dovrebbe essere pari a 6");

//        matrice colori
        assertNotNull(tableModel[0].getCellColors(), "la tabella colori non dovrebbe essere null");
        assertEquals( 0, tableModel[0].getCellColors().length,
                "Il caso limite dovrebbe fornire un numero di sequenze di colori pari a 0");

//        matrice indizi
        assertNotNull(tableModel[0].getHints(), "la tabella indizi non dovrebbe essere null");
        assertEquals(0,
                tableModel[0].getHints().length,
                "il caso limite dovrebbe fornire un numero di sequenze di indizi pari a 0");

//        metodo di richiamo stringhe headers
        for(int i = 0; i < tableModel[0].columnNames.length; i++) {
            assertEquals(tableModel[0].getColumnName(i),
                    tableModel[0].columnNames[i],
                    "il metodo dovrebbe restituire il valore alla cella corretta");
        }

//        metodo di richiamo numero righe tabella
        assertEquals(0,
                tableModel[0].getRowCount(),
                "il numero di righe dovrebbe essere coerente con il numero di tentativi disponibili");

//        metodo di richiamo numero colonne tabella
        assertEquals(tableModel[0].columnNames.length,
                tableModel[0].getColumnCount(),
                "il numero di colonne dovrebbe essere coerente con il numero di celle di Header");

//        la variabile è di tipo statico quindi alla definizione di un oggetto dell'array si sovrascrive la variabile
        tableModel[1] = new AttemptTableModel(5);
        Color[][] colors = tableModel[1].getCellColors();

//        tabella colori
        assertNotNull(colors, "la matrice colori non dovrebbe essere null");
        assertNotEquals(0,
                colors.length,
                "la matrice colori dovrebbe contenere un numero di righe diverse dal caso limite");
        for (Color[] color : colors) {
            assertFalse(color.length != 4,
                    "Il numero di colori per sequenza dovrebbe essere pari a 4");
        }

        //        metodo setter per simboli nella tabella
        int[][] indizi = tableModel[1].getHints();
        for(int i = 0; i < tableModel[1].getRowCount(); i++) {
            tableModel[1].setValueAt(0, i, 0);
            assertEquals(0,
                    indizi[i][0],
                    "i valori inseriti nella colonna 0 della tabella" +
                            " dovrebbero corrispondere agli indizi in colonna 0");
            tableModel[1].setValueAt(0,i, 5);
            assertEquals(0,
                    indizi[i][1],
                    "i valori inseriti nella colonna 5 della tabella" +
                            " dovrebbero corrispondere agli indizi in colonna 1");
        }
        try {
            tableModel[1].setValueAt(5, 6, 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I parametri inseriti non sono nel range di indici ammessi");
        }



//        metodo per il richiamo di un simbolo dalla tabella
        for(int i = -10; i < 11; i++) {
            for(int j = -10; j < 11; j++) {
                if (i >= 0 && i < tableModel[1].getRowCount()) {
                    if(j == 0) {
                        assertNotEquals("",
                                Integer.toString(indizi[i][j]),
                                "i simboli dovrebbero essere presenti solamente" +
                                        " nella colonna 0 della tabella e nelle righe ammesse");
                    } else if (j == 5) {
                        assertNotEquals("",
                                Integer.toString(indizi[i][1]),
                                "i simboli dovrebbero essere presenti solamente" +
                                        " nella colonna 5 della tabella e nelle righe ammesse");
                    }
                }

            }
        }

//        test metodo di inserimento colori in matrice
        for(Color[] c: colors) {
            for(int i = 0; i < 4; i++) {
                c[i] = Color.black;
            }
            assertEquals(Color.black,
                    c[(int)(Math.random() * 3)],
                    "tutte le celle dovrebbero essere state colorate di nero");
        }
        try {
            tableModel[1].setCellColor(0, 0, Color.yellow);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("il metodo non dovrebbe modificare la matrice dei colori per parametri fuori dal range permesso");
        }

//        test metodo get per matrice colori
        for(int i = 0; i < colors.length; i++) {
            assertEquals(Color.white,
                    AttemptTableModel.getCellColor(i, 0),
                    "Il colore nella colonna 0 dovrebbe essere sempre bianco");
            assertEquals(Color.white,
                    AttemptTableModel.getCellColor(i, 5),
                    "Il colore nella colonna 5 dovrebbe essere sempre bianco");
            assertEquals(Color.black,
                    AttemptTableModel.getCellColor(i, (int)((Math.random() * 3)) + 1),
                    "Il colore nelle colonne da 1 a 4 dovrebbero restituire i colori dei tentativi");
        }


    }

}
