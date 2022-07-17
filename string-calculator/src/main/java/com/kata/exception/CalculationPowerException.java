package com.kata.exception;

public class CalculationPowerException extends RuntimeException{

    /**
     * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public CalculationPowerException() {
        super("계산기 전원이 꺼져있습니다.");
    }
}
