package com.juhi.spe_mini.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    // Square root function
    @GetMapping("/sqrt/{x}")
    public double squareRoot(@PathVariable double x) {
        return Math.sqrt(x);
    }

    // Factorial function
    @GetMapping("/factorial/{x}")
    public long factorial(@PathVariable int x) {
        if (x < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    // Natural Logarithm
    @GetMapping("/ln/{x}")
    public double naturalLog(@PathVariable double x) {
        if (x <= 0) throw new IllegalArgumentException("Logarithm is undefined for x ≤ 0");
        return Math.log(x);
    }


    @PostMapping("/power")
    public double power(@RequestParam double base, @RequestParam double exponent) {
        return Math.pow(base, exponent);
    }
}
