package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum Operation {
    PULS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDED("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BinaryOperator<Integer> expression;

    Operation(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Integer operation(Integer left, String operator, Integer right) {
        return Arrays.stream(values())
                .filter(ls -> Objects.equals(ls.operator, operator))
                .findFirst()
                .orElseThrow(CalculationSymbolException::new)
                .calculate(left, right);
    }

    private Integer calculate(Integer left, Integer right) {
        return expression.apply(left, right);
    }

}
