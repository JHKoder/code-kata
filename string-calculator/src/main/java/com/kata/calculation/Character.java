package com.kata.calculation;

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

            //연산자
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
                if (isEquls(target, comparisonTarget, i)) {
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

    private static boolean isEquls(String s1, String s2, int s1Len) {
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
