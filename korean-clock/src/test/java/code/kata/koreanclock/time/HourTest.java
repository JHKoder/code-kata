package code.kata.koreanclock.time;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("시 테스트")
public class HourTest {

    @ParameterizedTest
    @ValueSource(ints = {
            12,
            1,
            4,
            0
    })
    @DisplayName("시간별 좌표 인덱스를 가져올수 있다.")
    void timeIndexTest(int num) {
        Assertions.assertThat(Hour.findHour(num)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {
            13,
            15,
            25,
            50
    })
    @DisplayName("시간에 해당되는 시간이 없다면 예외가 발생한다.")
    void timeIndexNotTest(int num) {
        Assertions.assertThatCode(() -> Hour.findHour(num))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

}
