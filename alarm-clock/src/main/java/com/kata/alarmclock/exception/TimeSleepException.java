package com.kata.alarmclock.exception;

public class TimeSleepException extends RuntimeException{

    /**
     * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public TimeSleepException() {
        super("시간 정지 오류 발생");
    }

}
