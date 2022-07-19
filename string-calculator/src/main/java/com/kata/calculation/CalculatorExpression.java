package com.kata.calculation;

import static com.kata.calculation.Operation.operation;
import static java.util.stream.Collectors.toCollection;

import com.kata.exception.CalculatorException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class CalculatorExpression {

    private final Queue<String> calculatorList = new LinkedList<>();

    public CalculatorExpression(Queue<String> str) {
        calculatorList.addAll(str);
    }

    public Integer calculation() {
        Queue<String> operation = getOperationList();
        Queue<Integer> numbers = getNumbersList();

        return numbers.stream()
                .reduce((left, right) -> operation(left, operation.peek(), right))
                .orElseThrow(CalculatorException::new);
    }

    private Queue<String> getOperationList() {
        return calculatorList.stream()
                .filter(ls -> ls.matches("[*/+-]"))
                .collect(toCollection(LinkedList::new));
    }

    private Queue<Integer> getNumbersList() {
        return calculatorList.stream()
                .filter(ls -> ls.matches("[0-9]{1,}"))
                .flatMapToInt(ls -> IntStream.of(Integer.parseInt(ls)))
                .boxed()
                .collect(toCollection(LinkedList::new));
    }

}
