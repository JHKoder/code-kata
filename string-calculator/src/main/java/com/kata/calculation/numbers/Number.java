package com.kata.calculation.numbers;

import static com.kata.calculation.Validation.*;

import com.kata.calculation.Calculation;
import java.text.DecimalFormat;

public class Number implements Calculation {
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private String pram;


    public Number(String pram) {
        this.pram = pram;
    }

    @Override
    public String arithmetic() {
        OperationTree oper = new OperationTree();
        String temp = "";

        for (int i = 0; i < pram.length(); i++) {
            temp = slice(pram, i);
            if (temp.length() != 0 && temp.charAt(0) != ' ') {
                if (isAllSymbol(temp)) {
                    oper.append(temp.charAt(0));
                } else {
                    oper.append(strToDouble(temp));
                }

                i += temp.length() - 1;
            }
        }
        System.out.println("");
        //계산
        oper.operation();

        //계산값 리턴
        return df.format(oper.findTree()) + "";
    }

    private static String slice(String str, int len) {
        String temp = "";
        boolean isNumber = false;

        for (int i = len; i < str.length(); i++) {

            if (isNumber(str.charAt(i)) || '.' == str.charAt(i)) {
                isNumber = true;
                temp += str.charAt(i);
            } else if ('-' == str.charAt(i)) {
                // 빼기 혹은 -너스 구분
                if (i + 1 != str.length()) {
                    if (str.charAt(i + 1) == ' ') {
                        // 빼기라면
                        return "-";
                    }
                    //마이너스라면
                }
                temp += str.charAt(i);
            } else {
                if (isNumber) {
                    return temp;
                } else {
                    return str.charAt(i) + "";
                }
            }
        }
        return temp;
    }

    public static double strToDouble(String str) {
        double re = 0;
        boolean isDecimal = false;
        int decimalCount = 0;

        int me = 0;

        System.out.print(str+" ");

        if (str.charAt(0) == '-') {
            me = 1;
        }

        for (int i = me; i < str.length(); i++) {
            if (isDecimal) {
                decimalCount++;
            }
            if (str.charAt(i) == '.') {
                isDecimal = true;
            } else {
                re += str.charAt(i) - '0';

                if (i == str.length() - 1) {
                    break;
                }

                re *= 10;
            }
        }

        if (isDecimal) {
            int dec = 1;
            for (int i = 0; i < decimalCount; i++) {
                dec *= 10;
            }
            re /= dec;
        }

        if (me == 1) {
            re *= -1;
        }

        return re;
    }

}
