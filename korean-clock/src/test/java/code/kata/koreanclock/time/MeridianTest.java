package code.kata.koreanclock.time;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("자오정 테스트")
public class MeridianTest {

    @ParameterizedTest
    @CsvSource(value = {
            "12,0",
            "0,0"
    }, delimiterString = ",")
    @DisplayName("자오정 시간을 알수 있다.")
    void timeIndexTest(int hour, int minute) {
        System.out.println(hour + "," + minute);
        Assertions.assertThat(Meridian.isMeridian(hour, minute)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "12,30",
            "0,1"
    }, delimiterString = ",")
    @DisplayName("자오정 이 아닌 시간을 알수 있다.")
    void timeIndexNotTest(int hour, int minute) {
        Assertions.assertThat(Meridian.isMeridian(hour, minute)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "12,0",
            "0,0"
    }, delimiterString = ",")
    @DisplayName("자오정 시간을 좌표를 알수 있다.")
    void selectMeridian(int hour, int minute) {
        Assertions.assertThat(Meridian.findMeridian(hour, minute)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "12,1",
            "0,1"
    }, delimiterString = ",")
    @DisplayName("자오정 시간이 아닌 것들은 예외가 발생한다.")
    void selectNotMeridian(int hour, int minute) {
        Assertions.assertThatCode(() -> Meridian.findMeridian(hour, minute))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

}
