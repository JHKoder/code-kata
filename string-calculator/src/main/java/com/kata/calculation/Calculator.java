package com.kata.calculation;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;

public class Calculator {

    public Integer practice(String str) {

        CalculatorExpression calculatorExpression = new CalculatorExpression(stream(str.split(" "))
                .collect(toCollection(LinkedList::new)));

        return calculatorExpression.calculation();
    }


}
