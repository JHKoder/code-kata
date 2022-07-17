package com.kata;

import com.kata.calculation.Calculator;
import com.kata.io.BufferInput;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculator.on();
        Calculator.input((BufferInput.readLine()));
        Calculator.off();
    }

}
