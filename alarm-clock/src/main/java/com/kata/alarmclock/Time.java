package com.kata.alarmclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Time {
    private LocalTime localTime;

    public Time(String str) {
        localTime = strToLocalTime(str);
    }

    public Time() {
        localTime = LocalTime.now();
    }

    public void secondUp() {
        localTime = LocalTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        return this.localTime.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private LocalTime strToLocalTime(String str) {
        int[] times = Arrays.stream(str.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return LocalTime.of(times[0], times[1], times[2]);
    }
}
