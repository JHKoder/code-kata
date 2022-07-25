package com.kata.alarmclock;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Thread {

    private final Time time;
    private final Alarm alarm;

    public Clock(Alarm alarm) {
        time = new Time();
        this.alarm = alarm;
    }

    @Override
    public void run() {
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            time.secondUp();
            alarm.checkAlarm(time);
        }), new Date(), 1_000);
    }

    private static class ScheduleTask extends TimerTask {

        private final Runnable runnable;

        public ScheduleTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }

    }

}
