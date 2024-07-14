package it.unipv.ingsfw.test;

import it.unipv.ingsfw.model.Decoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private Decoder decoder;

    @BeforeEach
    void setup() {
        Decoder.resetInstance();
        decoder = Decoder.getInstance("player0");
    }

    @Test
    void testDecoderSingleton() {
        Decoder decoder1 = Decoder.getInstance("player1");

        assertSame(decoder, decoder1);
    }

    @Test
    void testDecoderName() {
        assertEquals("player0", decoder.getName());
    }

    @Test
    void testSetGetName() {
        decoder.setName("playerA");
        assertEquals("playerA", decoder.getName());
    }

    @Test
    void testSetGetPoints() {
        decoder.setPoints(10);
        assertEquals(10, decoder.getPoints());
    }

}