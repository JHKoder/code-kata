package com.kata;

import com.kata.alarmclock.Alarm;
import com.kata.alarmclock.AlarmClock;
import com.kata.alarmclock.Battery;
import com.kata.alarmclock.Time;

public class Main {

    public static void main(String[] args) {

        Alarm alarm = new Alarm();
        Battery battery = new Battery(100000);
        AlarmClock alarmClock = new AlarmClock(alarm, battery);

        alarm.add(new Time("0:20:10"));
        alarmClock.start();
        alarm.add(new Time("0:35:50"));
        alarm.add(new Time("0:36:20"));
        alarm.add(new Time("0:36:30"));

    }

}
