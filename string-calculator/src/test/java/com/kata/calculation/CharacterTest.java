package com.kata.calculation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Calculator calculator;

    @Test
    void 더하기_계산() {
        String str = "사과 + 나무";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @Test
    void 더하기_좌_와일드_계산() {
        String str = "사과 + *무";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과무");
    }

    @Test
    void 더하기_우_와일드_계산() {
        String str = "사과 + 무*";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("무사과");
    }

    @Test
    void 뺴기_계산() {
        String str = "사과 - 사";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과");

    }

    @Test
    void 뺴기_좌_와일드_계산() {
        String str = "문자열 계산기 - *계";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("산기");
    }

    @Test
    void 뺴기_우_와일드_계산() {
        String str = "문자열 계산기 - 열*";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("문자");
    }

    @Test
    void 따음표_적용_더하기(){
        String str = " \"문자열 + 계산기 \" + 작업";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("문자열 + 계산기작업");

    }


}
