package com.kata.calculation;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import com.kata.io.BufferInput;
import java.util.LinkedList;

public class Calculator {

    public void practice() {
        BufferInput bufferInput = new BufferInput();
        String str = bufferInput.input();

        CalculatorExpression calculatorExpression = new CalculatorExpression(stream(str.split(" "))
                .collect(toCollection(LinkedList::new)));

        System.out.println(calculatorExpression.calculation());
        bufferInput.close();
    }

}
