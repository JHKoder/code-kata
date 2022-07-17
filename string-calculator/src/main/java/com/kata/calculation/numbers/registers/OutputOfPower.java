package com.kata.calculation.numbers.registers;

import com.kata.calculation.numbers.Register;
import java.text.DecimalFormat;

public class OutputOfPower {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public String findTree(Register register) {
        if (register.next != null) {
            return findTree(register.next) + register.value;
        } else {

            return (df.format(register.value))+"";
        }
    }
}
