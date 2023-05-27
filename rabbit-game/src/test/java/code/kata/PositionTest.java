package code.kata;

import code.kata.exception.PositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("위치는 0~49 사이 값만 허용된다.")
    void positionRange(){
        Position position = new Position(40,40);
        assertThatThrownBy(() -> {
            position.moveX(50);
            position.moveY(50);
        }).isInstanceOf(PositionException.class);
    }
}
