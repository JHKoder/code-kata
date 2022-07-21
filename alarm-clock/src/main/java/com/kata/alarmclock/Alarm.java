package com.kata.alarmclock;

import static com.kata.alarmclock.Time.localTimeToTime;

import com.kata.alarmclock.exception.TimeSleepException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alarm extends Thread{

    private final List<Time> timer = new ArrayList<>();

    public void add(Time time) {
        this.timer.add(time);
    }

    public void checkAlarm() {
        Time time = localTimeToTime(LocalTime.now());

        for(Time ti:timer){
            if(time.equals(ti)){
                print();
            }
        }
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println("삐삐삐--");

            try {
                sleep(1000);
            } catch (InterruptedException ignored) {
                throw new TimeSleepException();
            }
        }
    }

}
