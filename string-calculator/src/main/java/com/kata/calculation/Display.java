package com.kata.calculation;

public class Display {

    private final Integer value;

    public Display(Integer value) {
        this.value=value;
    }

    public void print() {
        System.out.println(" 계산 값은 : "+value);
    }

}
