package code.kata.rockPaperScissors;

import code.kata.exception.HandTypeException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가위")
public class ScissorsTest {

    @Test
    @DisplayName("대결시 상대 타입이 가위,바위,보 가 아니라면 에러가 발생 합니다.")
    void scissorsFightTargetTypeNoneException(){
        //given
        Hand type = new Scissors();
        Hand hand = ignore -> null;

        //when
        ThrowableAssert.ThrowingCallable result = () -> type.fight(hand);

        //then
        Assertions.assertThatThrownBy(result)
                .isInstanceOf(HandTypeException.class);
    }
}
