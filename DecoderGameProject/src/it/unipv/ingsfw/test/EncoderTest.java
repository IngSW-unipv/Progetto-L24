package it.unipv.ingsfw.test;

import it.unipv.ingsfw.model.AutoEncoder;
import it.unipv.ingsfw.model.Encoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private Encoder encoder;

    @BeforeEach
    void setup() {
        Encoder.resetInstance();
        encoder = Encoder.getInstance("encoder0");
    }

    @Test
    void testEncoderSingleton() {
        Encoder encoder1 = Encoder.getInstance("encoder1");

        assertSame(encoder, encoder1);
    }

    @Test
    void testEncoderName() {
        assertEquals("encoder0", encoder.getName());
    }

    @Test
    void testSetGetName() {
        encoder.setName("playerB");
        assertEquals("playerB", encoder.getName());
    }

    @Test
    void testSetGetPoints() {
        encoder.setPoints(10);
        assertEquals(10, encoder.getPoints());
    }

    @Test
    void testAutoEncoderStrategy() {

        // Crea un'istanza di AutoEncoder
        AutoEncoder strategy = new AutoEncoder();

        // Imposta la strategia
        encoder.setStrategy(strategy);

        // Verifica che la strategia sia stata impostata correttamente
        encoder.generateSecretCode();
        ArrayList<Color> secretCode = encoder.getSecretCode();
        assertNotNull(secretCode);
        assertEquals(4, secretCode.size());
    }

    @Test
    void testGenerateSecretCode() {

        // Crea un'istanza di AutoEncoder e la applica all' Encoder
        AutoEncoder strategy = new AutoEncoder();
        encoder.setStrategy(strategy);

        encoder.generateSecretCode();

        // Verifica che il codice segreto sia stato generato
        // con le caratteristiche corrette
        ArrayList<Color> secretCode = encoder.getSecretCode();
        assertNotNull(secretCode);
        assertEquals(4, secretCode.size());
    }

    @Test
    void testEvaluateSequence() {

        // Crea un'istanza di AutoEncoder e la applica all' Encoder
        AutoEncoder strategy = new AutoEncoder();
        encoder.setStrategy(strategy);

        encoder.generateSecretCode();
        ArrayList<Color> secretCode = encoder.getSecretCode();

        // Crea una sequenza di prova per valutare
        ArrayList<Color> testSequence = new ArrayList<>();
        testSequence.add(secretCode.get(0));
        testSequence.add(secretCode.get(1));
        testSequence.add(secretCode.get(2));
        testSequence.add(secretCode.get(3));

        // Valuta la sequenza di prova
        int[] result = encoder.evaluateSequence(testSequence);

        // Verifica che il codice segreto e la sequenza di prova
        // siano uguali comportando un indizio di posizione corretta
        // pari a 4
        assertNotNull(result);
        assertEquals(4, result[1]); // Tutti i colori sono corretti e nella posizione corretta
    }
}