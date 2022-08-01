package com.kata.alarmclock;

public class AlarmClock extends Thread {

    private final Alarm alarm;
    private final Clock clock;

    public AlarmClock() {
        alarm = new Alarm();
        clock = new Clock(alarm);
        clock.start();
    }

    public void addTask(String hhMmSs) {
        alarm.addTask(hhMmSs);
    }

}
