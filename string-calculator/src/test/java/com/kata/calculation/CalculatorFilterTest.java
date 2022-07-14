package com.kata.calculation;

import com.kata.calculation.character.Character;
import com.kata.calculation.numbers.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자 숫자 계산기 구별 테스트")
public class CalculatorFilterTest {

    @Test
    void 문자_계산기를_리턴할수있다() {
        String str = "s + s";

        Calculation result = CalculatorFilter.of(str);

        Assertions.assertThat(result).isInstanceOf(Character.class);
    }

    @Test
    void 숫자_계산기를_리턴할수있다() {
        String str = "1 + 1";

        Calculation result = CalculatorFilter.of(str);

        Assertions.assertThat(result).isInstanceOf(Number.class);
    }

}
