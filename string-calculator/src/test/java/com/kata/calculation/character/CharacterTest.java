package com.kata.calculation.character;

import com.kata.calculation.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Calculator calculator;

    @Test
    void 뺴기1() {
        String str = "\"사과\" - 사";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과");
    }

    @Test
    void 뺴기2() {
        String str = "사과 - 과";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사");
    }

    @Test
    void 뺴기3() {
        String str = "과 - 사과";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과");
    }

    @Test
    void 뺴기4() {
        String str = "사과나무사진 - 사";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과나무진");
    }

    @Test
    void 뺴기5() {
        String str = "사과 - 사과";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("");
    }


    @Test
    void 뺴기6() {
        String str = "컴퓨터 과학 - 컴퓨터 과학";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("");
    }


    @Test
    void 뺴기7() {
        String str = "컴퓨터 과학 컴퓨터 - 컴퓨터";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("과학");
    }

    @Test
    void 뺴기8() {
        String str = "금 사과 - 사과머니";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("금사과");
    }

    @Test
    void 더하기1() {
        String str = "\"사과\" + \"나무\"";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");

    }

    @Test
    void 더하기2() {
        String str = "\"사과\" + \"나무\" + \"열매\"";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무열매");

    }

    @Test
    void 더하기3() {
        String str = "\"사과 + 나무\" + 열매";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과 + 나무열매");
    }

    @Test
    void 더하기4() {
        String str = "사과           +           나무               +             열매";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무열매");

    }

    @Test
    void 더하기5() {
        String str = "사과 + + 나무 + 열매      ";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무열매");

    }

    @Test
    void 복합계산1() {
        String str = "사과+나무-나무";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과");
    }

    @Test
    void 복합계산2() {
        String str = "사과+나무-나무+나무";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo("사과나무");
    }

    @Test
    void 복합계산3() {
        String str = "\"컴퓨터 과학 + 과학\" - 컴퓨터 + 시간";

        String result = calculator.input(str);

        Assertions.assertThat(result).isEqualTo(" 과학 + 과학시간");
    }


}
