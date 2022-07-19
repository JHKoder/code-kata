package com.kata.io;

import com.kata.calculation.Calculator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BufferInput {
    private static final Pattern patternEquation = Pattern.compile("([\\d\\s]+[+*/-]+ [\\s\\d]){1,}");

    private BufferedReader br = null;

    public BufferInput(Calculator calculator) {
        if (calculator == null) {  return;   }
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public String input() {
        try {
            String str =  br.readLine();
            formulaVerification(str);
            return str;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean formulaVerification(String str) {
        return patternEquation.matcher(str).matches();
    }

}
