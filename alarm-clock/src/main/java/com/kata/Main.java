package com.kata;

import com.kata.alarmclock.Alarm;
import com.kata.alarmclock.AlarmClock;
import com.kata.alarmclock.Time;

public class Main {

    public static void main(String[] args) {
        
        Alarm alarm = new Alarm();
        AlarmClock alarmClock = new AlarmClock(alarm);

        alarm.add(new Time("20:44:00"));
        alarmClock.start();
        alarm.add(new Time("23:44:00"));

    }

}
