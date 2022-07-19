package com.kata.calculation;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 + 3, 6",
    })
    @DisplayName("계산기 입력 정상")
    void calculatorInputNormal(String str, Integer result) {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.practice(str))
                .isEqualTo(result);
    }

}
