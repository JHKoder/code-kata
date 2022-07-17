package com.kata.calculation.numbers.registers;

import com.kata.calculation.numbers.Register;
import com.kata.common.Log;
import com.kata.exception.CalculationSymbolException;
import java.util.Objects;

public class Control {

    //제어
    //left - right 으로 병합
    public static void processing(Register left, Register oper, Register right) {

        left.value = Operation.operation(left.value, oper.operator, right.value);

        if (right.next != null) {
            left.next = right.next;
            right.next.left = left;
        }
    }

    //제어
    // ( a )  에서 a 만 남기는
    public static void removeParentheses(Register left, Register find, Register right) {

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

    //제어
    //"(" 을 만날떄까지의 최우선순위 구하는 함수
    public Register findLeftOperation(Register find, int min, Register save) {

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

    //제어
    public Register findFastOperation(Register register) {
        return findFastOperation(register, Integer.MAX_VALUE, register);
    }


    //제어
    public Register findFastOperation(Register find, int min, Register save) {

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

    public static int prioritySymbol(char operator) {
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
