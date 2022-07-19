package com.kata.calculation;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;

public class CalculatorExpressionTest {

    @Test
    void test(){
        String str="100 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10";
        CalculatorExpression calculatorExpression = new CalculatorExpression(stream(str.split(" "))
                .collect(toCollection(LinkedList::new)));

        System.out.println(calculatorExpression.calculation());
    }
}
