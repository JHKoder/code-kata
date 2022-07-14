package com.kata.calculation.character;

import static com.kata.calculation.Validation.isStrEquls;

import com.kata.calculation.Calculation;
import com.kata.exception.CalculationSymbolException;

public class Character implements Calculation {

    private String pram;

    public Character(String pram) {
        this.pram = pram;
    }

    @Override
    public String arithmetic() {
        String temp = "";
        String left = "";
        boolean isPuls = false;
        boolean isMinus = false;

        for (int i = 0; i < pram.length(); i++) {

            if ('+' == pram.charAt(i)) {
                if (isPuls) {
                    left = left + temp;
                } else if (isMinus) {
                    left = replace(left, temp);
                    isMinus = false;
                } else {
                    left = temp;
                }
                temp = "";
                isPuls = true;
            } else if ('-' == pram.charAt(i)) {
                if (isPuls) {
                    left = left + temp;
                    isPuls = false;
                } else if (isMinus) {
                    left = replace(left, temp);
                } else {
                    left = temp;
                }
                temp = "";
                isMinus = true;
            }
            // 묶음  표시
            else if ('"' == pram.charAt(i)) {
                //" " 사이 문자 구하는 블록
                int jtemp = getQuotesStrLen(pram, i);

                for (int j = i + 1; j < jtemp; j++) {
                    temp += pram.charAt(j);
                }

                i = jtemp;
            } else if (' ' != pram.charAt(i)) {
                temp += pram.charAt(i);
            }
        }

        if (isMinus) {
            left = replace(left, temp);
        } else if (isPuls) {
            left += temp;
        }
        return left;
    }


    public static String replace(String target, String comparisonTarget) {

        String returnValue = "";

        if (comparisonTarget.length() == 1) {
            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != comparisonTarget.charAt(0)) {
                    returnValue += target.charAt(i);
                }
            }
            return returnValue;

        }

        for (int i = 0; i < target.length(); i++) {
            boolean isCheck = false;

            if (target.charAt(i) == comparisonTarget.charAt(0)) {
                if (isStrEquls(target, comparisonTarget, i)) {
                    isCheck = true;
                    i += comparisonTarget.length() - 1;
                }
            }
            if (!isCheck) {
                returnValue += target.charAt(i);
            }
        }

        return returnValue;

    }

    private static int getQuotesStrLen(String str, int start) {

        if (start + 1 > str.length()) {
            throw new CalculationSymbolException();
        }

        for (int i = start + 1; i < str.length(); i++) {
            if ('\"' == str.charAt(i)) {
                return i;
            }
        }

        throw new CalculationSymbolException();

    }
}
