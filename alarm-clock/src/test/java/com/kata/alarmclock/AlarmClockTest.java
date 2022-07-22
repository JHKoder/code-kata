package com.kata.alarmclock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("알람 시계 테스트")
public class AlarmClockTest {

    @Test
    @DisplayName("알람 시계 생성")
    void alarmClockCreate(){
        AlarmClock alarmClock = new AlarmClock();

        Assertions.assertThat(alarmClock)
                .isNotNull();
    }


    @Test
    @DisplayName("알람을 추가 한다")
    void alarmAdd(){
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.alarm(0,10,10);

        Assertions.assertThat(alarmClock)
                .isNotNull();
    }

}
