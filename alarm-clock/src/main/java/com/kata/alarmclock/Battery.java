package com.kata.alarmclock;

public class Battery extends Thread {

    private int mAh;

    public Battery(int mAh) {
        this.mAh = mAh;
    }

    public Runnable useOneSecond(ThreadGroup group) {
        return () -> {
            if (--mAh <= 0) {
                group.interrupt();
            }
        };
    }

}
