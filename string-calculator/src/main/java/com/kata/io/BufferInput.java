package com.kata.io;

import com.kata.calculation.Calculator;
import com.kata.exception.CalculatorInputException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferInput {

    private BufferedReader br = null;

    public BufferInput(Calculator calculator) {
        if (calculator == null) {
            return;
        }
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public String input() {
        try {
            String str = br.readLine();
            calculationInputValidation(str);
            return str;
        } catch (Exception e) {
            throw new CalculatorInputException();
        }
    }

    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            throw new CalculatorInputException();
        }
    }

    public static void calculationInputValidation(String str) {
        if(!str.matches("([\\d\\s]+[+*/-]+ [\\s\\d]){1,}")){
            throw new CalculatorInputException();
        }
    }

}
