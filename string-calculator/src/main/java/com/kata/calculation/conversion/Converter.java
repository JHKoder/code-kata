package com.kata.calculation.conversion;

import static com.kata.calculation.Validation.isBlank;
import static com.kata.calculation.Validation.isNumber;
import static com.kata.calculation.Validation.isParentheses;
import static com.kata.calculation.Validation.isSymbol;

import com.kata.calculation.numbers.Register;

public class Converter {

    public static Register strToOperation(String pram) {
        Register oper = new Register();
        String temp = "";

        for (int i = 0; i < pram.length(); i++) {
            temp = slice(pram, i);
            if (!isBlank(temp)) {
                oper.append(temp);
                i += temp.length() - 1;
            }
        }

        return oper;
    }

    private static String slice(String str, int len) {

        if (str.charAt(len) == '-' && isNumber(str.charAt(len + 1))) {
            return strToNegativeNumber(str, len);
        } else if (isNumber(str.charAt(len))) {
            return strToStrNumber(str, len);
        }

        return strToSymbol(str, len);

    }

    private static String strToNegativeNumber(String str, int len) {
        return "-" + strToStrNumber(str, len + 1);
    }

    private static String strToSymbol(String str, int len) {
        return str.charAt(len) + "";
    }

    private static String strToStrNumber(String str, int len) {
        String temp = "";
        for (int i = len; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || isSymbol(str.charAt(i)) || isParentheses(str.charAt(i))) {
                break;
            }
            temp += str.charAt(i);
        }
        return temp;
    }

    public static double strToDouble(String str) {
        return Double.parseDouble(str);
    }

}
