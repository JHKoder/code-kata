package com.kata.alarmclock;

import java.util.TimerTask;

public class ScheduleTask extends TimerTask {
    private final Runnable runnable;

    public ScheduleTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }

}
