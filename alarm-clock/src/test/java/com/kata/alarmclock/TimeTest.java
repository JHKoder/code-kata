package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeCodeException;
import java.time.LocalTime;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("알람 시계 1급 객체 테스트")
public class TimeTest {

    @ParameterizedTest
    @CsvSource({
            "9:0:0",
            "23:59:59",
            "0:0:0",
    })
    @DisplayName("패턴을 지킨다.")
    void isPattern(String str) {
        int[] ints = Arrays.stream(str.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Time time = new Time(ints[0], ints[1], ints[2]);

        Assertions.assertThat(time.toString()).isEqualTo(str);

    }

    @ParameterizedTest
    @CsvSource({
            "24:60:60 ",
            "-1:-1:-1 ",
            "111:111:111",
    })
    @DisplayName("패턴을 지키지 않는 다면 예외가 발생한다.ㅏ")
    void isNotPattern(String str) {
        int[] ints = Arrays.stream(str.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Assertions.assertThatThrownBy(() -> new Time(ints[0], ints[1], ints[2]))
                .isInstanceOf(TimeCodeException.class)
                .hasMessage("시간 규약 불일치 오류");
    }

}
