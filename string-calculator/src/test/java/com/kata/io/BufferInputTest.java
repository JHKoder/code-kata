package com.kata.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 입력 테스트")
public class BufferInputTest {

    @Test
    @DisplayName("생성자에서 calculator 을 안 받고 input 사용시 예외가 발생한다.")
    void constructorInputException() {
        BufferInput bufferInput = new BufferInput(null);

        Assertions.assertThatThrownBy(bufferInput::input)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자에서 calculator 을 안 받고 close 사용시 예외가 발생한다.")
    void constructorCloseException2() {
        BufferInput bufferInput = new BufferInput(null);

        Assertions.assertThatThrownBy(bufferInput::close)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
