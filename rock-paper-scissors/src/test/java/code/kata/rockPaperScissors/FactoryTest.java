package code.kata.rockPaperScissors;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Factory")
public class FactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {
            -3, -2, -1,
            0, 4, 5
    })
    @DisplayName("1 ~ 3 범위를 벗어나 Exception 이 발생 했습니다.")
    void rangeOutException(int number) {
        //given
        Factory factory = new Factory();

        //when
        ThrowableAssert.ThrowingCallable result = () -> factory.apply(number);

        //then
        Assertions.assertThatThrownBy(result)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
