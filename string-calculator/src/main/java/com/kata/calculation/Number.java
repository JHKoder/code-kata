package com.kata.calculation;

import java.util.ArrayList;
import java.util.List;

public class Number implements Calculation {

    private String pram;

    public Number(String pram) {
        this.pram = pram;
    }

    @Override
    public String arithmetic() {
        List<String> list = new ArrayList<>();
        String temp = "";

        //  수식-> list 변환
        for (int i = 0; i < pram.length(); i++) {
            temp = slice(pram, i);
            if (temp.length() != 0 && temp.charAt(0) != ' ') {
                list.add(temp);
                i += temp.length() - 1;
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        OperationTree oper = new OperationTree();

        for (int i = 0; i < list.size(); i++) {
            oper.append(list.get(i));
        }
        //계산
        oper.findTree();
        oper.operation();
        int result = (int) oper.findTree();
        System.out.print("답 : " + result);
        return result+"";
    }

    public static String slice(String str, int len) {
        String temp = "";
        boolean isNumber = false;
        for (int i = len; i < str.length(); i++) {

            if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
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

}
