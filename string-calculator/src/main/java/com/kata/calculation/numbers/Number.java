package com.kata.calculation.numbers;

import com.kata.calculation.Calculation;
import com.kata.calculation.conversion.Converter;
import java.text.DecimalFormat;

public class Number implements Calculation {

    private String pram;

    public Number(String pram) {
        this.pram = pram;
    }

    @Override
    public String arithmetic() {
        Register opera = Converter.strToOperation(pram);

        Register.logic.operation(opera);

        return Register.outputOfPower.findTree(opera);
    }

}