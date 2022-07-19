package com.kata.calculation;


import java.util.regex.Pattern;

public class Validation {

    public static boolean formulaVerification(String str) {
        return Pattern.matches("([\\d\\s]+[+*/-]+ [\\s\\d]){1,}", str);
    }

    public static boolean isSymbol(String str){
        return Pattern.matches("[*/+-]",str);
    }

    public static boolean isNumber(String str) {
        return Pattern.matches("[0-9]",str);
    }

}
