package com.kata.alarmclock;

import java.time.LocalTime;
import java.util.List;

//알람 시계를 조합하는 틀이다.
public class AlarmClock {

    private final Clock clock;
    private final Alarm alarm;

    public AlarmClock(Alarm alarm) {
        this.alarm = alarm;
        clock = new Clock();
    }

    public void start() {
        try {
            for(int i=0;i<100;i++) {
                LocalTime localTime = LocalTime.now();
                List<Integer> timer = Time.slice(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());

                if (alarm.checkAlarm(timer)) {
                    alarm.print();
                }
                clock.print();

                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
    }

}
