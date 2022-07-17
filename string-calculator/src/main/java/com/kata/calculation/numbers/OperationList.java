package com.kata.calculation.numbers;

import static com.kata.calculation.Validation.isNumber;
import static com.kata.calculation.conversion.Converter.strToDouble;

import com.kata.common.Log;
import com.kata.exception.CalculationSymbolException;
import java.util.Objects;

public class OperationList {

    private OperationList next = null;
    private OperationList left = null;

    private double value;
    private char operator;

    public OperationList() {
    }


    public void append(String str) {
        if (isNumber(str) || str.length() > 1) {
            append(strToDouble(str));
        } else {
            append(str.charAt(0));
        }
    }

    private void append(double sp) {
        if (next == null) {
            value = sp;
            appendNext();
        } else {
            next.append(sp);
        }
    }

    private void append(char ch) {
        if (next == null) {
            operator = ch;
            appendNext();
        } else {
            next.append(ch);
        }
    }

    private void appendNext() {
        next = new OperationList();
        next.left = this;
    }

    public double findTree() {
        return findTree(next);
    }

    public void operation() {
        OperationList find = findFastOperation();

        if (Objects.equals(find.operator, ')')) {
            Log.info("( ) 병합");
            removeParentheses(find.left.left, find.left, find);
        } else {
            if (find.left != null) {
                processing(find.left, find, find.next);
            } else {
                return;
            }
        }

        if (next != null) {
            operation();
        }
    }


    private double findTree(OperationList operationList) {
        if (next != null) {
            return operationList.findTree(operationList.next) + value;
        } else {
            return value;
        }
    }

    //left - right 으로 병합
    private void processing(OperationList left, OperationList oper, OperationList right) {

        left.value = Operation.operation(left.value,oper.operator,right.value);

        if (right.next != null) {
            left.next = right.next;
            right.next.left = left;
        }
    }

    // ( a )  에서 a 만 남기는
    private void removeParentheses(OperationList left, OperationList find, OperationList right) {

        //( 처리
        if (left.left != null) {
            // ( 왼쪽에 연산자가 있을경우
            left.left.next = find;
            find.left = left.left;
        }

        if (right.next != null) {
            right.next.left = find;
            find.next = right.next;
        }

    }

    //"(" 을 만날떄까지의 최우선순위 구하는 함수
    private OperationList findLeftOperation(OperationList find, int min, OperationList save) {

        if (find == null) {
            throw new CalculationSymbolException();
        }

        if (Objects.equals(find.operator, '(')) {
            //우선순위가 가장 높은 객체 리턴
            return save;

        } else {
            //현재 연산자 가져오기

            if (find.operator == '\0') {
                // left 가 존재하는대 연산자가 아닐경우
                return findLeftOperation(find.left, min, save);

            } else {
                //찾는 연산자 우선순위 넘버 가져오기
                int priorityNum = prioritySymbol(find.operator);

                // ( 을 찾을때까지 우선 순위 구하는 곳
                if (min > priorityNum) {
                    min = priorityNum;
                    save = find;
                }

                // 우선순위가 더 있나 찾아보기
                return findLeftOperation(find.left, min, save);
            }
        }
    }

    private OperationList findFastOperation() {
        return findFastOperation(this, Integer.MAX_VALUE, this);
    }


    private OperationList findFastOperation(OperationList find, int min, OperationList save) {

        // 다음 주소값이 존재 하면 true
        if (find.next != null) {

            //연산자가 아닐경우
            if (find.operator == '\0') {
                return findFastOperation(find.next, min, save);
            }

            //연산자의 우선순위 비교시 숫자 가져오기
            int findNum = prioritySymbol(find.operator);

            // 연산자가 ")" 일떄
            if (findNum == 5) {
                // ")" 을 만났을때 "(" 을 만날떄까지 left 를 만날떄까지 반복
                Log.info("left find - ");
                return findLeftOperation(find, Integer.MAX_VALUE, save);
            }

            // *./,+,- 연산자일떄 현제 위치 값 저장
            if (min > findNum) {
                min = findNum;
                save = find;
            }

            return findFastOperation(find.next, min, save);
        }

        //다음값이 존재하지 않으면 저장했던 save 을 리턴
        return save;
    }

    private static int prioritySymbol(char operator) {
        switch (operator) {
            case '*':
                return 1;
            case '/':
                return 2;
            case '+':
                return 3;
            case '-':
                return 4;
            case ')':
                return 5;
        }
        return 10;
    }

}
