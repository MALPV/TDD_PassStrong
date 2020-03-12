package cl.desafiolatam.passstrength.model;

import androidx.annotation.VisibleForTesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerifierTest {

    private Verifier verifier;

    @Before
    public void setUp() {
        verifier = new Verifier();
    }

    @Test
    public void evaluatePass_weak() {
        String pass = "abc";
        int eval = verifier.evaluatePass(pass);
        assertEquals(eval, Verifier.WEAK);
    }

    @Test
    public void evaluatePass_medium() {
        String pass = "abcde";
        int eval = verifier.evaluatePass(pass);
        assertEquals(eval, Verifier.MEDIUM);
    }

    @Test
    public void evaluatePass_strong() {
        String pass = "Abcde";
        int eval = verifier.evaluatePass(pass);
        assertEquals(eval, Verifier.STRONG);
    }

    @Test
    public void evaluateUpper_upper() {
        String pass = "Upper";
        assertTrue(verifier.evaluateUpper(pass));
    }

    @Test
    public void evaluateUpper_normal() {
        String pass = "upper";
        assertFalse(verifier.evaluateUpper(pass));
    }

    @Test
    public void evaluateLength_ok() {
        String pass = "length";
        assertTrue(verifier.evaluateLength(pass));
    }

    @Test
    public void evaluateLength_short() {
        String pass = "abc";
        assertFalse(verifier.evaluateLength(pass));
    }
}