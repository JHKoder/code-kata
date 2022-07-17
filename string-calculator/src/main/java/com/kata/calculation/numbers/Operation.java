package com.kata.calculation.numbers;

import com.kata.common.Log;
import com.kata.exception.CalculationSymbolException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PULS('+', Double::sum),
    MINUS('-', (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2),
    DIVIDED('/', (num1, num2) -> num1 / num2);

    private char operator;
    private BiFunction<Double, Double, Double> expression;

    Operation(char operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double operation(double left,char operator,double right){
        return Arrays.stream(values())
                .filter(ls -> ls.operator == operator )
                .findFirst()
                .orElseThrow(CalculationSymbolException::new)
                .calculate(left,right);
    }

    private double calculate(double left, double right) {
        double result =  this.expression.apply(left,right);
        Log.info(left + " " + this.operator +" "+right + " = " + result);
        return result;
    }

}
