package com.kata.alarmclock;

public class AlarmClock extends Thread {

    private final Alarm alarm;
    private final Clock clock;

    public AlarmClock() {
        Time time = new Time();
        alarm = new Alarm(time);
        clock = new Clock(time);
    }

    public void addTask(String hhMmSs) {
        alarm.addTask(hhMmSs);
    }

    @Override
    public void start() {
        clock.start();
        alarm.start();
    }

}
