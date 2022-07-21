package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeCodeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("알람 시계 1급 객체 테스트")
public class TimeTest {

    @ParameterizedTest
    @CsvSource({
            "09:00:00",
            "23:59:59",
            "0:0:0",
    })
    @DisplayName("패턴을 지킨다.")
    void isPattern(String str) {
        Assertions.assertThatCode(() -> new Time(str))
                .isEqualTo(null);
    }

    @ParameterizedTest
    @CsvSource({
            "24:60:60",
            "-1:-1:-1",
            "111:111:111",
    })
    @DisplayName("패턴을 지키지 않는 다면 예외가 발생한다.ㅏ")
    void isNotPattern(String str) {
        Assertions.assertThatThrownBy(() -> new Time(str))
                .isInstanceOf(TimeCodeException.class)
                .hasMessage("시간 규약 불일치 오류");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10:58:59   ,   10:59:0",
            "23:59:59   ,   0:0:0 ",
            "0:0:0      ,   0:0:1",
    }, delimiter = ',')
    @DisplayName("1초 증가가 정상 이다.")
    void secondIncrease(String str, String result) {
        Time time = new Time(str);
        time.timeUp();
        Assertions.assertThat(time.toString()).isEqualTo(result);
    }

}
