package com.kata.calculation;

import java.util.regex.Pattern;

public class Validation {
    private static final Pattern patternEquation = Pattern.compile("([\\d\\s]+[+*/-]+ [\\s\\d]){1,}");
    private static final Pattern patternSymbol= Pattern.compile("[*/+-]");
    private static final Pattern patternNumber= Pattern.compile("[0-9]");

    public static boolean formulaVerification(String str) {
        return patternEquation.matcher(str).matches();
    }

    public static boolean isSymbol(String str){
        return patternSymbol.matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        return patternNumber.matcher(str).matches();
    }

}
