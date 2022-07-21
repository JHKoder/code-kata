package com.kata.alarmclock;

import com.kata.alarmclock.exception.TimeSleepException;

public class AlarmClock{

    private final Battery battery;
    private final Clock clock;
    private final Alarm alarm;

    public AlarmClock(Alarm alarm, Battery battery) {
        this.battery = battery;
        this.alarm = alarm;
        clock = new Clock();
    }

    public void start() {
        ThreadGroup group = new ThreadGroup("Alarm-Clock");

        Thread clockRunnable = new Thread(group, () -> {
            loop(clock::timeUp);
        },"clock");
        Thread batteryRunnable = new Thread(group, () -> {
            loop(battery.useOneSecond(group));
        },"battery");
        Thread alarmRunnable = new Thread(group, () -> {
            loop(alarm::checkAlarm);
        },"alarm");

        clockRunnable.start();
        batteryRunnable.start();
        alarmRunnable.start();

    }

    private void loop(Runnable runnable) {
        while(true){
            runnable.run();
            timeSleep();
        }
    }

    public  void timeSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
            throw new TimeSleepException();
        }
    }

}
