package com.kata.calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
public class CalculatorExpressionTest {

    @ParameterizedTest
    @CsvSource({
            "100 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10,  154",
            "1 + 2 * 3 / 3, 3",
            "2 * 2 / 2, 2",
    })
    @DisplayName("컬렉션 테스트")
    void collectionTest(String str, String result) {
        CalculatorExpression calculatorExpression = new CalculatorExpression(str);

        assertThat(calculatorExpression.calculation()).isEqualTo(Integer.parseInt(result));
    }
}
