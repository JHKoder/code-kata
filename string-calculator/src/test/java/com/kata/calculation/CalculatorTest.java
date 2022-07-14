package com.kata.calculation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
public class CalculatorTest {


    @Test
    void 문자_계산() {
        String str = "사과 + 나무";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @Test
    void 숫자_계산() {
        String str = "1 + 1";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("2");
    }

    @Test
    void 문자열이_들어간_수식은_문자_계산이된다() {
        String str = "나무 + 1";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("나무1");
    }

}
