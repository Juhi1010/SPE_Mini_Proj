package com.juhi.spe_mini.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSquareRoot() {
        double result = calculatorController.squareRoot(25);
        assertEquals(5.0, result, "Square root of 25 should be 5.0");
    }

    @Test
    void testFactorial() {
        long result = calculatorController.factorial(5);
        assertEquals(120, result, "Factorial of 5 should be 120");
    }

    @Test
    void testNaturalLog() {
        double result = calculatorController.naturalLog(Math.E); // ln(e) = 1
        assertEquals(1.0, result, 0.0001, "Natural log of e should be 1.0");
    }

    @Test
    void testPowerFunction() {
        double result = calculatorController.power(2, 3);
        assertEquals(8.0, result, "2^3 should be 8.0");
    }
}
