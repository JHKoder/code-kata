package com.kata.alarmclock;

import java.util.ArrayList;
import java.util.List;

public class Alarm {

    private List<Time> timer = new ArrayList<>();

    public Alarm() {
    }

    public void add(Time time) {
        timer.add(time);
    }

    public boolean checkAlarm(List<Integer> timer) {
        return this.timer.stream()
                .anyMatch(ls -> ls.equals(timer));
    }

    public void print() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("삐삐삐--");
            Thread.sleep(1000);
        }
    }

}
