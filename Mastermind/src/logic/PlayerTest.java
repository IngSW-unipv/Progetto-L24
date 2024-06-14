package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

     private Player[] player;

    @BeforeEach
    public void setUp() {
        player = new Player[4];
        player[0] = new Player(5);
        player[1] = new Player(10);
        player[2] = new Player(15);
        player[3] = new Player(0);
    }

    @Test
    public void testPlayer() {

        assertNotNull(player[0].getSequences(), "Sequences non dovrebbe essere nullo");
        assertNotNull(player[3].getSequences(), "Sequences non dovrebbe essere nullo");
        assertFalse(player[3].getSequences().length != 0,
                "Il caso limite dovrebbe fornire un numero di sequenze pari a 0" );

        for(int[] s: player[0].getSequences()) {
            assertFalse(s.length != 4, "Ogni sequenza dovrebbe salvare solo 4 valori");
        }
        assertFalse(player[0].getSequences().length != 5,
                "Il numero di sequenze dovrebbe coincidere con la difficoltà selezionata");
        assertFalse(player[1].getSequences().length != 10,
                "Il numero di sequenze dovrebbe coincidere con la difficoltà selezionata");
        assertFalse(player[2].getSequences().length != 15,
                "Il numero di sequenze dovrebbe coincidere con la difficoltà selezionata");
    }


}
