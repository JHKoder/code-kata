package com.kata.alarmclock.exception;

public class TimeCodeException extends RuntimeException{

    /**
     * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public TimeCodeException() {
        super("시간 규약 불일치 오류");
    }

}
