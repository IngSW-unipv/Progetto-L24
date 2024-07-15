package it.unipv.ingsfw.test;

import it.unipv.ingsfw.Observer;
import it.unipv.ingsfw.model.AutoEncoder;
import it.unipv.ingsfw.model.EncoderStrategy;
import it.unipv.ingsfw.model.GameFacade;
import it.unipv.ingsfw.view.ViewFacade;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFacadeTest {

    private GameFacade gameFacade;

    @BeforeEach
    void setUp() {
        gameFacade = GameFacade.getInstance();
    }

    @Test
    void testSingletonInstance() {
        GameFacade anotherInstance = GameFacade.getInstance();
        assertSame(gameFacade, anotherInstance);
    }

    @Test
    void testCreateNewEncoder() {
        EncoderStrategy strategy = new AutoEncoder();
        Observer observer = ViewFacade.getInstance();

        gameFacade.createNewEncoder("encoder", strategy, observer);

        assertNotNull(gameFacade.getEncoder());
        assertEquals("encoder", gameFacade.getEncoder().getName());
        assertSame(strategy, gameFacade.getEncoder().getStrategy());
    }

    @Test
    void testCreateNewDecoder() {
        Observer observer = ViewFacade.getInstance();

        gameFacade.createNewDecoder("decoder", observer);

        assertNotNull(gameFacade.getDecoder());
        assertEquals("decoder", gameFacade.getDecoder().getName());
    }

    @Test
    void testCreateNewGame() {
        gameFacade.createNewGame(100);

        assertNotNull(gameFacade.getGame());
        assertEquals(100, gameFacade.getGame().getId());
    }

    @Test
    void testInitializeAttemptsLeft() {
        gameFacade.createNewGame(100);
        gameFacade.getGame().defineTotalAttempts("EASY"); // Assuming EASY difficulty has 10 attempts
        gameFacade.initializeAttemptsLeft();

        assertEquals(15, gameFacade.getAttemptsLeft());
    }

    @Test
    void testHasAttemptsLeft() {
        gameFacade.createNewGame(100);
        gameFacade.getGame().defineTotalAttempts("EASY"); // Assuming EASY difficulty has 10 attempts
        gameFacade.initializeAttemptsLeft();

        assertTrue(gameFacade.hasAttemptsLeft());

        for (int i = 0; i < 15; i++) {
            gameFacade.endTurn();
        }

        assertFalse(gameFacade.hasAttemptsLeft());
    }

    @Test
    void testCheckWinHint() {
        int[] winHint = {0, 4};
        gameFacade.createNewGame(100);
        gameFacade.getGame().initializeHints(1); // Initialize hints
        gameFacade.getGame().addHint(winHint);

        assertTrue(gameFacade.checkWinHint());
    }

    @Test
    void testPlayTurn() {
        ArrayList<Color> sequence = new ArrayList<>();
        sequence.add(Color.ORANGE);
        sequence.add(Color.YELLOW);
        sequence.add(Color.GREEN);
        sequence.add(Color.BLUE);

        gameFacade.createNewGame(50);
        gameFacade.createNewEncoder("encoder", new AutoEncoder(), ViewFacade.getInstance());
        gameFacade.getEncoder().generateSecretCode();
        gameFacade.getGame().defineTotalAttempts("EASY");
        gameFacade.initializeAttemptsLeft();
        gameFacade.getGame().initializeHints(gameFacade.getGame().getTotAttempts());

        gameFacade.playTurn(sequence);

        assertEquals(1, gameFacade.getGame().getSequences().size());
        assertEquals(sequence, gameFacade.getGame().getSequences().get(0));
    }

    @Test
    void testEndTurn() {
        gameFacade.createNewGame(50);
        gameFacade.getGame().defineTotalAttempts("EASY");
        gameFacade.initializeAttemptsLeft();

        gameFacade.endTurn();

        assertEquals(1, gameFacade.getGame().getAttemptPlayed());
        assertEquals(14, gameFacade.getAttemptsLeft());
    }

    @Test
    void testWinGame() {
        gameFacade.createNewGame(100);
        gameFacade.createNewDecoder("decoder", ViewFacade.getInstance());
//        Test per difficoltà Easy che aggiunge 1 punto
        gameFacade.getGame().defineTotalAttempts("EASY");
        gameFacade.winGame();
        assertEquals(1, gameFacade.getDecoder().getPoints());
//        Test per difficoltà Normal che aggiunge 2 punto
        gameFacade.getGame().defineTotalAttempts("NORMAL");
        gameFacade.winGame();
        assertEquals(3, gameFacade.getDecoder().getPoints());
//Test per difficoltà Hard che aggiunge 3 punto
        gameFacade.getGame().defineTotalAttempts("HARD");
        gameFacade.winGame();
        assertEquals(6, gameFacade.getDecoder().getPoints());
    }

    @Test
    void testLooseGame() {
        gameFacade.createNewGame(1);
        gameFacade.createNewEncoder("TestEncoder", new AutoEncoder(), ViewFacade.getInstance());

        gameFacade.looseGame();

        assertEquals(1, gameFacade.getEncoder().getPoints());
    }

    @Test
    void testConvertSecretCodeToString() {
        ArrayList<Color> secretCode = new ArrayList<>();
        secretCode.add(Color.ORANGE);
        secretCode.add(Color.YELLOW);
        secretCode.add(Color.GREEN);
        secretCode.add(Color.BLUE);

        gameFacade.createNewEncoder("TestEncoder", new AutoEncoder(), ViewFacade.getInstance());
        gameFacade.getEncoder().getStrategy().setSecretCode(secretCode);

        ArrayList<String> colorNames = gameFacade.convertSecretCodeToString();

        assertEquals(4, colorNames.size());
        assertEquals("Arancio", colorNames.get(0));
        assertEquals("Giallo", colorNames.get(1));
        assertEquals("Verde", colorNames.get(2));
        assertEquals("Blu", colorNames.get(3));
    }

}