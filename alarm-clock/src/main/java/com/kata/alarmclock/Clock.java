package com.kata.alarmclock;

import static com.kata.alarmclock.Time.localTimeToTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clock extends Thread{

    private final List<Time> timer = new ArrayList<>();

    public Clock() {
        timer.add(localTimeToTime(LocalTime.now()));
    }

    public void timeUp() {
        timer.get(0).print();
        timer.get(0).timeUp();
    }

    @Override
    public void run() {
        timeUp();
    }

}
