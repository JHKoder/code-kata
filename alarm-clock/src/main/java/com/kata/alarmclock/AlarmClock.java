package com.kata.alarmclock;

public class AlarmClock extends Thread {
    private Pint pint;
    private final Alarm alarm;
    private final Clock clock;

    public AlarmClock() {
        pint = new Pint();
        alarm = new Alarm(pint);
        clock = new Clock(alarm,pint);
    }

    public void addTask(String hhMmSs) {
        alarm.addTask(hhMmSs);
    }

    public void start(){
        clock.start();
    }
}
