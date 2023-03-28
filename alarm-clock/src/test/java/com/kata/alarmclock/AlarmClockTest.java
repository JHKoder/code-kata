package com.kata.alarmclock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("알람 시계 테스트")
public class AlarmClockTest {

    @Test
    @DisplayName("알람 시계 생성")
    void alarmClockCreate() {
        AlarmClock alarmClock = new AlarmClock();

    }

    @Test
    @DisplayName("알람을 추가 한다")
    void alarmAdd() {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.addTask("0:10:10");

        assertThat(alarmClock).isNotNull();
    }

}
