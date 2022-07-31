package code.kata.koreanclock.time;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("분 태스트")
public class MinuteTest {

    @ParameterizedTest
    @ValueSource(ints = {
            12,
            38,
            0,
            59
    })
    @DisplayName("분별 좌표 인덱스를 가져올수 있다.")
    void timeIndexTest(int num) {
        Assertions.assertThat(MinuteEnum.findMinute(num)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -30,
            100,
            60,
            10000
    })
    @DisplayName("시간에 해당되는 시간이 없다면 예외가 발생한다.")
    void timeIndexNotTest(int num) {
        Assertions.assertThatCode(() -> MinuteEnum.findMinute(num))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

}
