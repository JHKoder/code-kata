package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("유효성 검증 테스트")
public class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "~", "!", "@", "#", "$",
            "%", "^", "&", "(", ")",
            "_", "=", "{", "}", "[",
            "]", ";", ":", "'", "\"",
            "<", ",", ">", ".", "?",
            "\\", "|"
    })
    @DisplayName("연산자 기호가 아니면 예외가 발생한다.")
    void operatorSymbolOtherwiseException(String opera) {
        //given
        Integer left = 10;
        Integer right = 2;

        //when
        Assertions.assertThatThrownBy(() -> Operation.operation(left, opera, right))
                .isInstanceOf(CalculationSymbolException.class)
                .hasMessage("잘못된 기호가 들어갔습니다.");
    }

}
