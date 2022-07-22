package com.kata.calculation;

import static com.kata.calculation.Operation.operation;
import static java.lang.Integer.parseInt;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class CalculatorExpression {

    private final Queue<String> calculatorList = new LinkedList<>();

    public CalculatorExpression(Queue<String> str) {
        calculatorList.addAll(str);
    }

    public Integer calculation() {

        Integer sum = parseInt(Objects.requireNonNull(calculatorList.poll()));

        while(true){
            if(calculatorList.peek() == null) return sum;
            sum = operation(sum, calculatorList.poll(),  parseInt(Objects.requireNonNull(calculatorList.poll())));
        }
    }

}
