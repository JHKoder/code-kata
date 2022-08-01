package com.kata.alarmclock;

import com.kata.alarmclock.exception.AlarmClockShutdownException;
import java.util.HashSet;
import java.util.Set;

public class Alarm {

    private final Set<Time> timer = new HashSet<>();

    public void addTask(String alarmTime) {
        timer.add(new Time(alarmTime));
    }

    public void checkAlarm(Time time) {

        if (timer.size()==0) {
            throw new AlarmClockShutdownException();
        }
        timer.removeIf(queue -> queueEqualsIf(queue, time));
        System.out.println("현재 시간 - " + time);
    }

    public boolean queueEqualsIf(Time queue, Time time) {
        if (queue.equals(time)) {
            System.out.println("삐삐삐");
            return true;
        }
        return false;
    }

}
