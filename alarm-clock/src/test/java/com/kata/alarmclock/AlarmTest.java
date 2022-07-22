package com.kata.alarmclock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("알람 테스트")
public class AlarmTest {

    @Test
    @DisplayName("알람 추가")
    void test() {
        AlarmClock alarmClock = new AlarmClock();

        alarmClock.alarm(1, 1, 1);

        Assertions.assertThatCode(() -> alarmClock.alarm(1, 1, 1))
                .isEqualTo(null);
    }

    @Test
    @DisplayName("알람이 울린다")
    void test2() {

        Alarm alarm = new Alarm();

        Time target = new Time(1, 1, 1);
        Time compare = new Time(1, 1, 1);

        Assertions.assertThat(alarm.queueEqualsIf(target, compare))
                .isTrue();
    }

}
