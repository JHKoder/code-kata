package com.kata.calculation.numbers;

import com.kata.calculation.Calculator;
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
        String str = "1 + 11 + 1 + 1";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("14");
    }

    @Test
    void 뺴기() {
        String str = " 1 - 1";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("0");
    }

    @Test
    void 곱하기() {
        String str = " 10 * 10";

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
    void 소수점_계산() {
        String str = "10 - 0.05";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("9.95");
    }


    @Test
    void 마이너스_계산() {
        String str = "10 + -10";
        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("0");
    }

    @Test
    void 괄호_계산1() {
        String str = "2 * (1 +2 ) ";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("6");
    }

    @Test
    void 괄호_우선순위_계산() {
        String str = "2 * (1 + 10 * 2 ) ";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("42");
    }


    @Test
    void 우선순위_계산() {
        String str = "5 * 5 + 10 / 2 - 1 ";
        //25 + 5 - 1
        // 24
        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("29");

    }


    @Test
    void 복합연산_1() {
        String str = "10 * (10 + 5)";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("150");
    }

    @Test
    void 복합연산_2() {
        String str = "3453 * -2 * 10 + (88 - 30 * 4)";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("-69092");
    }

    @Test
    void 복합연산_3() {
        String str = "(100/20) * (10/5) / 2 + (5*2) * -50 ";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("-495");
    }
    @Test
    void 복합연산_4() {
        String str = "(1200) * 1 * (4 + (10 + 5 * 10) * 15)";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("1084800");
    }

}
