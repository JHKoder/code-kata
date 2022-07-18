package com.kata.calculation;


import java.util.regex.Pattern;

public class Validation {

    private static final String EQUATION_PATTERN = "[0-9]*.[?+?/?*?-].[0-9$]*";

    public static boolean formulaVerification(String str) {
        return Pattern.matches(EQUATION_PATTERN, str);
    }

    public static boolean isSymbol(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean isNumber(char ch) {
        return '0' <= ch && '9' >= ch;
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
