package com.kata.calculation;

import static com.kata.calculation.Operation.operation;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatorExpression {

    private final Queue<String> calculatorList;

    public CalculatorExpression(String inputCalculator) {
        calculatorList = stream(inputCalculator.split(" "))
                .collect(toCollection(LinkedList::new));
    }

    public Integer calculation() {
        Integer sum = parseInt(calculatorList.poll());

        while (!calculatorList.isEmpty()) {
            sum = operation(sum, calculatorList.poll(), parseInt(calculatorList.poll()));
        }
        return sum;

    }

}
