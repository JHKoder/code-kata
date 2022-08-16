package com.kata.alarmclock;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Thread {

    private final Time time;
    private final Alarm alarm;
    private final Pint out;

    public Clock(Alarm alarm,Pint pint) {
        time = new Time();
        this.out = pint;
        this.alarm = alarm;
    }

    @Override
    public void start() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new ScheduleTask(() -> {
            time.secondUp();
            alarm.checkAlarm(time,timer);
            out.print("현재 시간 - " + time);
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
