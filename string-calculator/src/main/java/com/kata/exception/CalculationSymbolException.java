package com.kata.exception;

public class CalculationSymbolException extends RuntimeException{

    public CalculationSymbolException() {
        super("잘못된 기호가 들어갔습니다.");
    }

    public CalculationSymbolException(String message) {
        super(message);
    }
}
