package com.kata.alarmclock;

import java.time.LocalTime;

public class Clock {

    private final Time time;

    public Clock() {
        LocalTime localTime = LocalTime.now();

        this.time = new Time(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    public Time timer() {
        System.out.println(timerMessage());
        return time.timeUp(LocalTime.now());
    }

    public String timerMessage() {
        return time.toString();
    }

}
