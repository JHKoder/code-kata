package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeCodeException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Time {

    private List<Integer> time = new ArrayList<>();

    public Time(int hour, int minute, int second) {
        pattern(hour, minute, second);
        time.addAll(List.of(hour, minute, second));
    }

    public Time timeUp(LocalTime localTime) {
        time.set(2, localTime.getSecond());
        time.set(1, localTime.getMinute());
        time.set(0, localTime.getHour());
        return this;
    }

    public boolean equals(Time object) {
        if (object==null) return false;

        return Objects.equals(this.time.get(0), object.time.get(0)) &&
                Objects.equals(this.time.get(1), object.time.get(1)) &&
                Objects.equals(this.time.get(2), object.time.get(2));
    }

    @Override
    public String toString() {
        return time.get(0) + ":" + time.get(1) + ":" + time.get(2);
    }

    private void pattern(int hour, int minute, int second) {
        if (!(isHour(hour) &&
                isMinute(minute) &&
                isSecond(second))) {
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
