package com.juhi.spe_mini;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpeMiniApplicationTest {

    @Test
    void testSquareRoot() {
        assertEquals(3.0, Math.sqrt(9), 0.0001);
        assertEquals(2.0, Math.sqrt(4), 0.0001);
        assertEquals(5.0, Math.sqrt(25), 0.0001);
    }

    @Test
    void testFactorial() {
        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
    }

    @Test
    void testNaturalLogarithm() {
        assertEquals(0.0, Math.log(1), 0.0001);
        assertEquals(1.0, Math.log(Math.E), 0.0001);
        assertEquals(2.3026, Math.log(10), 0.0001);
    }

    @Test
    void testPowerFunction() {
        assertEquals(8.0, Math.pow(2, 3), 0.0001);
        assertEquals(1.0, Math.pow(5, 0), 0.0001);
        assertEquals(16.0, Math.pow(4, 2), 0.0001);
    }

    // Helper method for factorial
    private static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

