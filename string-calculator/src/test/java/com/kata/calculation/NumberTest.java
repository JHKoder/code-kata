package com.kata.calculation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    private Calculator calculator;

    @Test
    void 더하기() {
        String str = "1 + 1";

        String result = calculator.input(str);
        Assertions.assertThat(result).isEqualTo("2");
    }

    @Test
    void 더하기2() {
        String str = "1 + 1 + 1 + 1";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("4");
    }

    @Test
    void 뺴기() {
        String str = " 1 - 1";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("0");
    }

    @Test
    void 곱하기() {
        String str = "10 * 10";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("100");
    }

    @Test
    void 나누기() {
        String str = "10 / 10";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("1");
    }

    @Test
    void 마이너스_계산() {
        String str = "10 + -10";
        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("0");
    }

    @Test
    void 괄호_계산() {
        String str = "(1 + 1) * 2";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("4");
    }

    @Test
    void 복합연산_1() {
        String str = "10 * (10 + 5)";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("150");
    }

    @Test
    void 복합연산_2() {
        String str = "10 * (10 + 5) / ( -99 * (-10 + (5 * 1)))";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("742.5");
    }

    @Test
    void 복합연산_3() {
        String str = "1 + ((2 - 3) * (4 * ((5 + 6) / 7 ) / 8) * 10";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("");
    }


}
