package com.kata.calculation.numbers;

import static com.kata.calculation.Validation.isNumber;
import static com.kata.calculation.conversion.Converter.strToDouble;

import com.kata.calculation.numbers.registers.Control;
import com.kata.calculation.numbers.registers.Logic;
import com.kata.calculation.numbers.registers.OutputOfPower;

public class Register {

    public static Control control = new Control();
    public static Logic logic=new Logic();
    public static OutputOfPower outputOfPower = new OutputOfPower();

    public Register next = null;
    public Register left = null;

    public double value;
    public char operator;

    public Register() {
    }

    //기억
    public void append(String str) {
        if (isNumber(str) || str.length() > 1) {
            append(strToDouble(str));
        } else {
            append(str.charAt(0));
        }
    }

    //기억
    private void append(double sp) {
        if (next == null) {
            value = sp;
            appendNext();
        } else {
            next.append(sp);
        }
    }

    //memory
    private void append(char ch) {
        if (next == null) {
            operator = ch;
            appendNext();
        } else {
            next.append(ch);
        }
    }

    //기억
    private void appendNext() {
        next = new Register();
        next.left = this;
    }

}
