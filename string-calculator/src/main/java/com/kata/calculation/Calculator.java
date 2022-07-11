package com.kata.calculation;

public class Calculator {

    public static String input(String str) {
        Calculation result = CalculatorFilter.of(str);
        return result.arithmetic();
    }


}
