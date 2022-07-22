package com.kata.alarmclock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("시계 테스트")
public class ClockTest {

    @Test
    @DisplayName("알람 시계에 1~2초의 시간이 지나간다.")
    void timeIsRunningOut() throws InterruptedException {

        Clock clock = new Clock();
        String target = clock.timerMessage();

        Thread.sleep(2000);

        clock.timer();
        String result = clock.timerMessage();

        Assertions.assertThat(target).isNotEqualTo(result);
    }

}
