package com.kata.alarmclock;

import com.kata.alarmclock.exception.AlarmClockShutdownException;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class Alarm {
    private final Set<Time> timer = new HashSet<>();
    private final Pint out;

    public Alarm(Pint out) {
        this.out = out;
    }

    public void addTask(String alarmTime) {
        timer.add(new Time(alarmTime));
    }

    public void checkAlarm(Time time, Timer timers) {

        if (timer.size()==0) {
            throw new AlarmClockShutdownException();
        }

        try {
            timer.removeIf(queue -> queueEqualsIf(queue, time));
        }catch (UnsupportedOperationException e){
            out.shutdown();
            timers.cancel();
        }
    }

    public boolean queueEqualsIf(Time queue, Time time) {
        if (queue.equals(time)) {
            out.print("삐삐삐");
            return true;
        }
        return false;
    }
}
