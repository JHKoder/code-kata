package com.kata.calculation;

import com.kata.calculation.character.Character;
import com.kata.calculation.numbers.Number;
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
            if (Validation.isAlphabet(str.charAt(i)) || Validation.isKorean(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

}
