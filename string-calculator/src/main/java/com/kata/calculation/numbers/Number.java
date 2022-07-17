package com.kata.calculation.numbers;

import com.kata.calculation.Calculation;
import com.kata.calculation.conversion.Converter;
import java.text.DecimalFormat;

public class Number implements Calculation {

    private static final DecimalFormat df = new DecimalFormat("#.##");
    private String pram;

    public Number(String pram) {
        this.pram = pram;
    }

    @Override
    public String arithmetic() {
        OperationList opera = Converter.strToOperation(pram);

        opera.operation();

        return df.format(opera.findTree()) + "";
    }

}