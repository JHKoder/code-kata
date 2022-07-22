package com.kata.alarmclock;

import com.kata.alarmclock.exception.AlarmClockShutdownException;
import java.util.LinkedList;
import java.util.Queue;

public class Alarm {

    private final Queue<Time> timer = new LinkedList<>();

    public Alarm() {
    }

    public void add(int hour, int minute, int second) {
        timer.add(new Time(hour, minute, second));
    }

    public void checkAlarm(Time time) {
        if (timer.size()==0) {
            throw new AlarmClockShutdownException();
        }
        timer.removeIf(queue -> queueEqualsIf(queue, time));
    }

    public boolean queueEqualsIf(Time queue, Time time) {
        if (queue.equals(time)) {
            System.out.println("삐삐삐");
            return true;
        }
        return false;
    }

}
