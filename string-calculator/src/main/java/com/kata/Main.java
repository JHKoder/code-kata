package com.kata;

import com.kata.calculation.Calculator;
import com.kata.calculation.Display;
import com.kata.io.BufferInput;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        BufferInput bufferInput = new BufferInput(calculator);
        Display display = new Display(calculator.practice(bufferInput.input()));

        display.print();
        bufferInput.close();
    }

}
