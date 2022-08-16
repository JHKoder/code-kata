package com.kata.alarmclock;

import static com.google.common.truth.Truth.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("알람 테스트")
public class AlarmTest {

    @Test
    @DisplayName("알람 추가")
    void test() {
        Alarm alarm = new Alarm(new Pint());

        Assertions.assertThatCode(() -> alarm.addTask("1:1:1"))
                .isEqualTo(null);
    }

    @Test
    @DisplayName("알람이 울린다")
    void test2() {

        Time target = new Time("1:1:1");
        Time compare = new Time("1:1:1");

        assertThat(target).isEqualTo(compare);
    }

}
