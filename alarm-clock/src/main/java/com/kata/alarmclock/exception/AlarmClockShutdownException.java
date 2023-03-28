package com.kata.alarmclock.exception;

public class AlarmClockShutdownException extends RuntimeException{
    public AlarmClockShutdownException() {
        super("알람 시계 종료");
    }
}
