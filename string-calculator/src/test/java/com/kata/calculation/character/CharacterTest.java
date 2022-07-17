package com.kata.calculation.character;

import com.kata.calculation.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 문자 계산기 테스트")
public class CharacterTest {

    @BeforeEach
    void setup(){
        Calculator.on();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "\"사과나무\" - 사",
            "독사과나무 - 독사",
            "과나무씨앗 - 씨앗",
            "과나무 씨앗 - 씨앗",
            "\"과나무 씨앗 뿌리\" - \" 씨앗 뿌리\""
    })
    void 뺴기(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과나무");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "사 + 과 + 나 + 무",
            "사과 + 나무",
            "\"사과\" + 나무",
            "사 + + + + 과 + 나 + 무",
            "사과 + \"나\" +무"
    })
    void 더하기(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "사과 + 나무 + 뿌리 - 뿌리",
            "\"사과나무\" + 뿌리 - 뿌리",
            "\"사과나무 + 뿌리\" - \" + 뿌리\"",
    })
    void 복합계산(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "\"사과나무 + 뿌리\" - 사과 + 뿌리",
            " - 뿌리 + 나무 + \" + \" + 뿌리뿌리"
    })
    void 복합계산2(String str) {
        String result = Calculator.input(str);

        Assertions.assertThat(result).isEqualTo("나무 + 뿌리뿌리");
    }


}
