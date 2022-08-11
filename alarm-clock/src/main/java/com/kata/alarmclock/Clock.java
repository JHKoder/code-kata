package com.kata.alarmclock;

import java.util.Date;
import java.util.Timer;

public class Clock extends Thread {

    private final Time time;
    public Clock(Time time) {
        this.time =time;
    }

    @Override
    public void start() {
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            time.secondUp();
            System.out.println("현재 시간 - " + time);
        }), new Date(), 1_000);
    }

}
