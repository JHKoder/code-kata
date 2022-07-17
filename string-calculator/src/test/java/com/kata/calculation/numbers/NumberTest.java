package com.kata.calculation.numbers;

import com.kata.calculation.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 숫자 계산기 테스트")
public class NumberTest {

    @BeforeEach
    void setup(){
        Calculator.on();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "4+6", "1+4+5", "2+2 + 2+2+2",
    })
    void 더하기(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("10");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "12 - 2 ", " 100 - 90", "15 - 2 - 3"
    })
    void 뺴기(String str) {

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("10");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1*18", "2*9", "3*6"
    })
    void 곱하기(String str) {

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("18");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "18/3", "12/2", "54/9"
    })
    void 나누기(String str) {

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("6");
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "10 - 0.05", "9 + 0.95"
    })
    void 소수점_계산(String str) {

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("9.95");
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "-10 * -10", "-100 / -1", " 110 + -10", "50 - -50"
    })
    void 마이너스_계산(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("100");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1+(3+2)", "(10 - 5)+1", "(2*5) - 4", "(10/2)+1"
    })
    void 괄호_계산1(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("6");
    }

    @Test
    void 괄호_우선순위_계산() {
        String str = "2+(100/20+40/1+10*45/5+2*100)";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("337").isNotEqualTo("17102");
    }

    @Test
    void 우선순위_계산() {
        String str = "5 * 5 + 10 / 2 - 1 ";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("29").isNotEqualTo("16.5");
    }

    @Test
    void 복합연산_1() {
        String str = "10 * (10 + 5)";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("150");
    }

    @Test
    void 복합연산_2() {
        String str = "3453 * -2 * 10 + (88 - 30 * 4)";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("-69092");
    }

    @Test
    void 복합연산_3() {
        String str = "(100/20) * (10/5) / 2 + (5*2) * -50 ";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("-495");
    }

    @Test
    void 복합연산_4() {
        String str = "(1200) * 1 * (4 + (10 + 5 * 10) * 15)";

        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("1084800");
    }

}
