package com.kata.calculation;

import static com.kata.calculation.Operation.operation;
import static java.lang.Integer.parseInt;

import java.util.Queue;

public class CalculatorExpression {

    private final Queue<String> calculatorList;

    public CalculatorExpression(Queue<String> str) {
        this.calculatorList = str;
    }

    @SuppressWarnings("all")
    public Integer calculation() {
        Integer sum = parseInt(calculatorList.poll());

        while (!calculatorList.isEmpty()) {
            sum = operation(sum, calculatorList.poll(), parseInt(calculatorList.poll()));
        }
        return sum;

    }

}
