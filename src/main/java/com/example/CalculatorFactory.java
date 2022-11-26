package com.example;

import com.example.arithmetics.Calculator;

public class CalculatorFactory {

    private static int calculatorInstance = 0;
    private static Calculator calculation;

    public static Calculator getCalculations() {
        if (CalculatorFactory.calculatorInstance != 1) {
            CalculatorFactory.calculation = new Calculator();
            CalculatorFactory.calculatorInstance += 1;
        }
        return CalculatorFactory.calculation;
    }
}
