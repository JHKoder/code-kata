package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;

public class Validation {

    public static boolean isAlphabet(char ch) {
        return isCapitalLetter(ch) || isSmallLetter(ch);
    }

    public static boolean isBlank(String str) {
        return str.length() == 0 || str.charAt(0) == ' ';
    }

    public static boolean isCapitalLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isSmallLetter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isKorean(char ch) {
        return ch >= '가' && ch <= '힣';
    }

    public static boolean isSymbol(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean isParentheses(char ch) {
        return ch == '(' || ch == ')';
    }

    public static boolean isAllSymbol(String str) {
        char ch = stringToChar(str);
        return ((isSymbol(ch) || isParentheses(ch)) && str.length() == 1);
    }

    // ==========================     character    ==============================
    public static boolean isStrEquls(String s1, String s2, int s1Len) {
        // s1 길이와 s2 길이
        if (s1.length() - s1Len < s2.length()) {
            return false;
        }

        for (int i = s1Len; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    return false;
                }
                if (j == s2.length() - 1) {
                    return true;
                }
            }
        }
        return true;
    }
    // ==========================     number       ==============================

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

    private static char stringToChar(String str) {
        if (str.length() == 0) {
            throw new CalculationSymbolException();
        }
        return str.charAt(0);
    }

}
