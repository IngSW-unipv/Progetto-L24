package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing del sistema di generazione del codice segreto.
 */
public class CodeGenerationTest {

    private Game game;

    /**
     * Operazioni in preparazione al test
     */
    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    /**
     * Operazioni di test sul codice segreto.
     */
    @Test
    public void testSetSecretCode() {
        game.setSecretCode();
        int[] secretCode = game.getSecretCode();
        assertNotNull(secretCode, "SecretCode non dovrebbe essere nullo");
        assertEquals(4, secretCode.length, "SecretCode dovrebbe avere dimensione 4");
        for(int s: secretCode) {
            assertFalse(s < 0 || s > 5, "SecretCode dovrebbe contenere solo valori ammessi");
        }

        // controllo per valori unici
        for (int i = 0; i < secretCode.length; i++) {
            for (int j = i + 1; j < secretCode.length; j++) {
                assertNotEquals(secretCode[i], secretCode[j], "SecretCode dovrebbe contenere solo valori unici");
            }
        }
    }
}
