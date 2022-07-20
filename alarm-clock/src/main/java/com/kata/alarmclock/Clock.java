package com.kata.alarmclock;

import static com.kata.alarmclock.Time.localTimeToTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// 이 객체는 시계 바늘을 담당한다.
public class Clock {

    private List<Time> timer = new ArrayList<>();

    public Clock() {
        timer.add(localTimeToTime(LocalTime.now()));
    }

    public void print() {
        timer.get(0).print();
        timer.get(0).timeUp();
    }


}
