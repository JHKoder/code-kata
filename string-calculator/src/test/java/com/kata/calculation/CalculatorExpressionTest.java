package com.kata.calculation;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 1급 컬렉션 테스트")
public class CalculatorExpressionTest {

    @Test
    @DisplayName("컬렉션 테스트")
    void collectionTest(){
        String str="100 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10";
        CalculatorExpression calculatorExpression = new CalculatorExpression(stream(str.split(" "))
                .collect(toCollection(LinkedList::new)));

        System.out.println(calculatorExpression.calculation());
    }
}
