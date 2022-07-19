package com.kata.exception;

public class CalculatorException extends RuntimeException{

    public CalculatorException() {
        super("계산 실패");
    }
}
