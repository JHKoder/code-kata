package com.kata;

import com.kata.alarmclock.AlarmClock;

public class Main {

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();

        alarmClock.alarm(9, 30, 1);
        alarmClock.alarm(9, 30, 5);
    }

}
