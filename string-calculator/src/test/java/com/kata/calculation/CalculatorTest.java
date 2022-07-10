package com.kata.calculation;

import com.kata.exception.CalculationFailureException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    void 문자_계산(){
        String str ="사과 + 나무";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @Test
    void 숫자_계산(){
        String str ="1 + 1";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("2");
    }

    @Test
    void 계산기는_숫자_문자계산을_한번에_못한다(){
        String str ="나무 + 1";

        Assertions.assertThatThrownBy( () ->  calculator.input(str))
                .isInstanceOf(CalculationFailureException.class)
                .hasMessage("");

    }

}
