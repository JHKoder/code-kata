package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeCodeException;
import java.time.LocalTime;
import java.util.List;

public class Time {

    private List<Integer> time;

    public Time(int hour, int minute, int second) {
        pattern(hour, minute, second);
        time = List.of(hour, minute, second);
    }

    public Time timeUp(LocalTime localTime) {
        time = List.of(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return this;
    }

    public boolean equals(Time object) {
        return this.time.equals(object.time);
    }

    @Override
    public String toString() {
        return time.get(0) + ":" + time.get(1) + ":" + time.get(2);
    }

    private void pattern(int hour, int minute, int second) {
        if (!(isHour(hour) && isMinute(minute) && isSecond(second))) {
            throw new TimeCodeException();
        }
    }

    private boolean isHour(int hour) {
        return hour >= 0 && hour <= 23;
    }

    private boolean isMinute(int minute) {
        return minute >= 0 && minute <= 59;
    }

    private boolean isSecond(int second) {
        return second >= 0 && second <= 59;
    }

}
