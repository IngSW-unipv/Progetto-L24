package it.unipv.ingsfw.test;

import it.unipv.ingsfw.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testGameInitialization() {
        assertEquals("Not started", game.getState());
        assertEquals(0, game.getTotAttempts());
        assertEquals(0, game.getAttemptPlayed());
    }

    @Test
    void testStartGame() {
        game.start();
        assertEquals("Started", game.getState());
    }

    @Test
    void testEndGame() {
        game.end();
        assertEquals("Ended", game.getState());
    }

    @Test
    void testSetGetId() {
        game.setId(100);
        assertEquals(100, game.getId());
    }

    @Test
    void testDefineTotalAttempts() {
        game.defineTotalAttempts("EASY");
        assertEquals(15, game.getTotAttempts());
    }

    @Test
    void testSetGetAttemptPlayed() {
        game.setAttemptPlayed(10);
        assertEquals(10, game.getAttemptPlayed());
    }

    @Test
    void testAddGetSequences() {
        ArrayList<Color> sequence = new ArrayList<>();
        sequence.add(Color.ORANGE);
        sequence.add(Color.YELLOW);
        sequence.add(Color.GREEN);
        sequence.add(Color.BLUE);

        game.addSequence(sequence);

        ArrayList<ArrayList<Color>> sequences = game.getSequences();
        assertNotNull(sequences);
        assertEquals(1, sequences.size());
        assertEquals(sequence, sequences.get(0));
    }

    @Test
    void testInitializeAddHint() {
        game.initializeHints(5);
        int[] hint = {4, 0};

        game.setAttemptPlayed(0);
        game.addHint(hint);

        assertArrayEquals(hint, game.getLastHint());
    }

    @Test
    void testGetLastHintWithNoHints() {
        game.initializeHints(5);
        assertNull(game.getLastHint());
    }

    @Test
    void testGetLastHintWithHints() {
        game.initializeHints(5);
        int[] hint1 = {4, 0};
        int[] hint2 = {3, 1};

        game.setAttemptPlayed(0);
        game.addHint(hint1);
        game.setAttemptPlayed(1);
        game.addHint(hint2);

        assertArrayEquals(hint2, game.getLastHint());
    }

}