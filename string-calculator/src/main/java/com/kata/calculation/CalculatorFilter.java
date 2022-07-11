package com.kata.calculation;

import com.kata.exception.CalculationFailureException;

public class CalculatorFilter {

    public static Calculation of(String str) {
        return isCharacter(str);
    }

    private static Calculation isCharacter(String str) {
        boolean result = lettersAreFalseAndNumbersAreTrue(str);

        if (result) {
            return new Character(str);
        }

        return new Number(str);
    }

    // true: number , false: character
    private static boolean lettersAreFalseAndNumbersAreTrue(String str) {

        if (str.length() == 0) {
            throw new CalculationFailureException("입력 받은게 없습니다.");
        }

        for (int i = 0; i < str.length(); i++) {
            if (isAlphabet(str.charAt(i)) || isKorean(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean isAlphabet(char ch) {
        return isCapitalLetter(ch) || isSmallLetter(ch);
    }

    private static boolean isCapitalLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private static boolean isSmallLetter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isKorean(char ch) {
        return ch >= '가' && ch <= '힣';
    }


}
