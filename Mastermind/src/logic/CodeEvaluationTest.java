package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodeEvaluationTest {

    private Game game;
    private CodeEvaluation codeEvaluation;

    @BeforeEach
    public void setUp() {
        game = new Game();
        codeEvaluation = new CodeEvaluation();
    }

    @Test
    public void testEvaluation() {
        int[] code, guess, hints;
        assertNotNull(codeEvaluation.getHints(), "Hints non dovrebbe essere nullo");
        assertEquals(2, codeEvaluation.getHints().length, "Hints dovrebbe avere dimensione 2");
        game.setSecretCode();
        code = game.getSecretCode();
        game.setSecretCode();
        guess = game.getSecretCode();
        codeEvaluation.setCode(code);
        codeEvaluation.setGuess(guess);
        codeEvaluation.start();
        try {
            codeEvaluation.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hints = codeEvaluation.getHints();
        for(int s: hints) {
            assertFalse(s < 0 || s > 4, "hint dovrebbe contenere solo valori ammessi");
        }
    }
}
