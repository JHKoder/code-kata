package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operation {
    PULS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDED("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operation(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Integer calculation(List<String> operation, List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            numbers.set(i, Operation.operation(numbers.get(i - 1), operation.get(i - 1), numbers.get(i)));
        }
        return numbers.get(numbers.size() - 1);
    }

    public static Integer operation(Integer left, String operator, Integer right) {
        return Arrays.stream(values())
                .filter(ls -> Objects.equals(ls.operator, operator))
                .findFirst()
                .orElseThrow(CalculationSymbolException::new)
                .calculate(left, right);
    }

    private Integer calculate(Integer left, Integer right) {
        return this.expression.apply(left, right);
    }

}
