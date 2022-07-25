package com.kata;

import com.kata.alarmclock.AlarmClock;

public class Main {

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock();

        alarmClock.addTask("21:12:50");
        alarmClock.addTask("21:13:10");
        alarmClock.addTask("21:13:20");

        alarmClock.run();

    }

}
