package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeCodeException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 이 객체는 시간 규격을 09:01:00 담당한다.
public class Time {

    private List<Integer> time;

    public Time(String str) {
        timePattern(str);
        time = slice(str);
    }

    public void timeUp() {
        secondUp();
        if (time.get(2) >= 60) {
            time.set(2, 0);
            minuteUp();
        }
        if (time.get(1) >= 60) {
            time.set(1, 0);
            hourUp();
        }
        if (time.get(0) >= 24) {
            time.set(0, 0);
        }
    }

    private void secondUp() {
        int second = time.get(2) + 1;
        time.set(2, second);
    }

    private void minuteUp() {
        int minute = time.get(1) + 1;
        time.set(1, minute);
    }

    private void hourUp() {
        int hour = time.get(0) + 1;
        time.set(0, hour);
    }

    public static List<Integer> slice(String str) {
        return Arrays.stream(str.split(":"))
                .flatMapToInt(ls -> IntStream.of(Integer.parseInt(ls)))
                .boxed()
                .collect(Collectors.toList());
    }

    public static Time localTimeToTime(LocalTime localTime) {
        return new Time(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());
    }

    public void print() {
        System.out.println(time.get(0) + ":" + time.get(1) + ":" + time.get(2));
    }

    public String toString() {
        return time.get(0) + ":" + time.get(1) + ":" + time.get(2);
    }

    public boolean equals(List<Integer> time) {
        return Objects.equals(this.time.get(0), time.get(0)) &&
                Objects.equals(this.time.get(1), time.get(1)) &&
                Objects.equals(this.time.get(2), time.get(2));
    }

    private void timePattern(String str) {

        System.out.println(str);
        System.out.println(str.matches("([0-9]|0[0-9]|[0-2][0-3]):([0-9]|0[0-9]|[0-5][0-9]):([0-5][0-9]|[0-9])"));
        if (!str.matches("([0-9]|0[0-9]|[0-2][0-3]):([0-9]|0[0-9]|[0-5][0-9]):([0-5][0-9]|[0-9])")) {
            throw new TimeCodeException();
        }
    }

}
