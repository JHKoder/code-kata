package com.kata.calculation;

import com.kata.io.BufferInput;

public class Calculator {

    public void arithmetic() {
        BufferInput bufferInput = new BufferInput();
        String inputCalculator = bufferInput.input();

        CalculatorExpression calculatorExpression = new CalculatorExpression(inputCalculator);

        System.out.println(calculatorExpression.calculation());
        bufferInput.close();
    }

}
