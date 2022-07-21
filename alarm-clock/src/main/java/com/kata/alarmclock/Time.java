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
        System.out.println(this);
    }

    public boolean equals(Time object) {
        return Objects.equals(this.time.get(0), object.time.get(0)) &&
                Objects.equals(this.time.get(1), object.time.get(1)) &&
                Objects.equals(this.time.get(2), object.time.get(2));
    }

    @Override
    public String toString(){
        return time.get(0) + ":" + time.get(1) + ":" + time.get(2);
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

    private void timePattern(String str) {
        if (!str.matches("([0-9]|0[0-9]|[0-2][0-3]):([0-9]|0[0-9]|[0-5][0-9]):([0-5][0-9]|[0-9])")) {
            throw new TimeCodeException();
        }
    }

}
