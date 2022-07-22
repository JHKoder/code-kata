package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeSleepException;

public class AlarmClock extends Thread {

    private final Alarm alarm = new Alarm();
    private final Clock clock = new Clock();

    public AlarmClock() {
        start();
    }

    public void alarm(int hour, int minute, int second) {
        alarm.add(hour, minute, second);
    }

    public void start() {
        threadLoopRun(() -> {
            Time time = clock.timer();
            alarm.checkAlarm(time);
        });
    }

    private void threadLoopRun(Runnable runnable) {
        new Thread(() -> loop(runnable), "timer").start();
    }

    private void loop(Runnable runnable) {
        timeSleep(200);

        while (true) {
            runnable.run();
            timeSleep(1000);
        }
    }

    private void timeSleep(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ignored) {
            throw new TimeSleepException();
        }
    }

}
