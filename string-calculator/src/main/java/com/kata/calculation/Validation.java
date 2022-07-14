package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;

public class Validation {
    public static boolean isAlphabet(char ch) {
        return isCapitalLetter(ch) || isSmallLetter(ch);
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

    public static boolean isSymbol(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    public static boolean isParentheses(char ch) {
        return ch == '(' || ch == ')';
    }
    public static boolean isAllSymbol(String str){
        char ch = stringToChar(str);
        return ((isSymbol(ch) || isParentheses(ch)) && str.length() == 1);
    }



    // ==========================     number       ==============================

    public static boolean isNumber(char ch){
        return '0' <= ch && '9' >= ch;
    }

    public static boolean isNumber(String str){
        char ch = stringToChar(str);
        return '0' <= ch && '9' >=ch;
    }

    private static char stringToChar(String str){
        if(str.length() == 0 )
            throw new CalculationSymbolException();
        return str.charAt(0);
    }
}
