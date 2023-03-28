package com.kata.exception;

public class CalculatorInputException extends RuntimeException{
    public CalculatorInputException() {
        super("계산기 입력 오류");
    }
}
