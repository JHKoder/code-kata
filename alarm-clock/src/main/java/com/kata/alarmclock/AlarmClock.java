package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeSleepException;
import java.util.Optional;

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
        threadLoopRun(() -> alarm.checkAlarm(clock.timer()));
    }

    private void threadLoopRun(Runnable runnable) {
        new Thread(() -> loop(runnable), "timer").start();
    }

    private void loop(Runnable runnable) {
        runnable.run();
        timeSleep();
        loop(runnable);
    }

    private void timeSleep() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException ignored) {
            throw new TimeSleepException();
        }
    }

}
