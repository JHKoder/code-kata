package com.kata.alarmclock;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.DateTimeException;

@DisplayName("알람 시계 시간 테스트")
public class TimeTest {

    @ParameterizedTest
    @CsvSource({
            "24:60:60 ",
            "-1:-1:-1 ",
            "111:111:111",
    })
    @DisplayName("패턴을 지키지 않는 다면 예외가 발생한다.")
    void isNotPattern(String str) {
        Assertions.assertThatThrownBy(() -> new Time(str))
                .isInstanceOf(DateTimeException.class);
    }
}
