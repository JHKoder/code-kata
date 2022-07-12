package com.kata.calculation;

import com.kata.exception.CalculationSymbolException;

public class OperationTree {

    public OperationTree next = null;

    public Long index;
    public double value;
    public String operator;
    public boolean isContention = true;

    public OperationTree() {
        index = 0L;
    }

    public OperationTree(Long index) {
        this.index = index;
    }

    public void append(String sp) {

        if (next == null) {
            //마이너스

            if ((isSymbol(sp) || isParentheses(sp)) && sp.length() == 1) {
                //연산자라면 혹은 소괄호 라면
                operator = sp;

            } else {
                //숫자라면
                value = strToLong(sp);
            }

            next = new OperationTree(index + 1);
        } else {
            next.append(sp);
        }

    }

    public String operation() {
        for (int i=0;i<2000;i++) { // 반복문 범위를 벗어 날때
            if (this.next.next!= null) {
                operation(this);
            } else {
                return "";
            }
        }
        return "";
    }

    public String operation(OperationTree left) {


        if(next==null){
            return null;
        }
        //연산자라면
        if (operator == null) {

            next.leftRightOperation(left);

            return null;
        }

        next.operation(this);

        return null;
    }

    public void leftRightOperation(OperationTree left) {
        double leftNum = left.value;
        char operat = this.operator.charAt(0);
        double rightNum = next.value;
        double sum = 0;

        if (priority(operat) == 3) {
            sum = leftNum * rightNum;
        } else if (priority(operat) == 4) {
            sum = leftNum / rightNum;
        } else if (priority(operat) == 5) {
            sum = leftNum + rightNum;
        } else if (priority(operat) == 6) {
            sum = leftNum - rightNum;
        }

        left.next = this.next.next;
        left.value = sum;

    }


    public double findTree() {
        return findTree(next);
    }

    private double findTree(OperationTree operationTree) {
        if (next != null) {
            return operationTree.findTree(operationTree.next) + value;
        } else {
            return value;
        }
    }

    //우선순위 검색
    public int priority(char operator) {
        switch (operator) {
            case '(':
                return 1;
            case ')':
                return 2;
            case '*':
                return 3;
            case '/':
                return 4;
            case '+':
                return 5;
            case '-':
                return 6;
        }
        throw new CalculationSymbolException();
    }


    private boolean isParentheses(String sp) {
        char ch = sp.charAt(0);
        return ch == '(' || ch == ')';
    }


    private boolean isSymbol(String sp) {
        char ch = sp.charAt(0);
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }


    public static long strToLong(String str) {
        System.out.println(">>"+str);

        long re = 0;
        int me=0;

        if(str.charAt(0) == '-'){
            me=1;
        }
        for (int i = me; i < str.length(); i++) {
            re += str.charAt(i) - '0';

            if (i == str.length() - 1) {
                break;
            }

            re *= 10;
        }
        if(me==1){
            re*=-1;
        }
        return re;
    }


}
