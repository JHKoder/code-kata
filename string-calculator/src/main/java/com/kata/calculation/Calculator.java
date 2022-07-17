package com.kata.calculation;


import com.kata.exception.CalculationPowerException;

public class Calculator {

    private static boolean power  = false;

    private Calculator() {
    }

    public static String input(String str) {
        isPower();
        Calculation result = CalculatorFilter.of(str);
        return result.arithmetic();
    }

    public static void isPower(){
        if(!power){
            throw new CalculationPowerException();
        }
    }

    public static void on() {
        power=true;
    }

    public static void off() {
        power= false;
    }

}
