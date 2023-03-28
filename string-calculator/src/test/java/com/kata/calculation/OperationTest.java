package com.kata.calculation;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연산 테스트")
public class OperationTest {

    @Test
    @DisplayName("더하기 성공")
    void plusSuccess() {
        //given
        Integer left = 10;
        String opera = "+";
        Integer right = 2;

        //when
        Integer result = Operation.operation(left, opera, right);

        //then
        Assertions.assertThat(result)
                .isEqualTo(12);
    }

    @Test
    @DisplayName("뺴기 성공")
    void findOutSuccess() {
        //given
        Integer left = 10;
        String opera = "-";
        Integer right = 2;

        //when
        Integer result = Operation.operation(left, opera, right);

        //then
        Assertions.assertThat(result)
                .isEqualTo(8);
    }

    @Test
    @DisplayName("나누기_성공")
    void divideSuccess() {
        //given
        Integer left = 10;
        String opera = "/";
        Integer right = 2;

        //when
        Integer result = Operation.operation(left, opera, right);

        //then
        Assertions.assertThat(result)
                .isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈_성공")
    void multiplicationSuccess() {
        //given
        Integer left = 10;
        String opera = "*";
        Integer right = 2;

        //when
        Integer result = Operation.operation(left, opera, right);

        //then
        Assertions.assertThat(result)
                .isEqualTo(20);
    }
}
