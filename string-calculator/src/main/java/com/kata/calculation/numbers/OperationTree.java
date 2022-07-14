package com.kata.calculation.numbers;

import com.kata.common.Garbage;
import com.kata.exception.CalculationSymbolException;
import java.util.Objects;

public class OperationTree {

    public OperationTree next = null;
    public OperationTree left = null;

    public double value;
    public char operator;

    public OperationTree() {}

    public void append(double sp) {

        if (next == null) {
            value =sp;
            next = new OperationTree();
            next.left = this;
        } else {
            next.append(sp);
        }

    }

    public void append(char ch) {

        if (next == null) {
            operator =ch;
            next = new OperationTree();
            next.left = this;
        } else {
            next.append(ch);
        }

    }

    public void operation() {
        OperationTree find = findFastOperation();

        if (Objects.equals(find.operator, ')')) {
            System.out.println("( ) 병합");
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

    //left - right 으로 병합
    private void processing(OperationTree left, OperationTree oper, OperationTree right) {

        double sum = arithmetic(left.value, oper.operator, right.value);

        left.value = sum;
        if (right.next != null) {
            left.next = right.next;
            right.next.left = left;
        }
        Garbage.remove(oper);
    }

    // ( a )  에서 a 만 남기는
    private OperationTree removeParentheses(OperationTree left, OperationTree find, OperationTree right) {

        //( 처리
        if (left.left != null) {
            // ( 왼쪽에 연산자가 있을경우
            left.left.next=find;
            find.left=left.left;
            Garbage.remove(left);
        }else{
            Garbage.remove(find.left);
        }

        // ) 처리
        if (right.next != null) {
            // ) 오른쪽에 연산자가 있을경우
            right.next.left = find;
            find.next=right.next;
            Garbage.remove(right);
        } else {
            Garbage.remove(find.next,right);
        }

        return find;
    }

    //"(" 을 만날떄까지의 최우선순위 구하는 함수
    private OperationTree findLeftOperation(OperationTree find, int min, OperationTree save) {

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

    private OperationTree findFastOperation() {
        return findFastOperation(this, Integer.MAX_VALUE, this);
    }

    /**
     * 최우선 연산이 필요한곳은 찾는 메소드
     *
     * @param find 재귀 하면서 비교할 값
     * @param min  우선순위 비교 숫자
     * @param save 우선순위가 제일 높은 객체
     *
     * @return 우선순위가 제일 높은 객체
     */
    private OperationTree findFastOperation(OperationTree find, int min, OperationTree save) {

        // 다음 주소값이 존재 하면 true
        if (find.next != null) {

            //연산자가 아닐경우
            if (find.operator =='\0') {
                return findFastOperation(find.next, min, save);
            }

            //연산자의 우선순위 비교시 숫자 가져오기
            int findNum = prioritySymbol(find.operator);

            // 연산자가 ")" 일떄
            if (findNum == 5) {
                // ")" 을 만났을때 "(" 을 만날떄까지 left 를 만날떄까지 반복
                System.out.println("left find -");
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

    private double arithmetic(double left, char ch, double right) {

        switch (ch) {
            case '*':
                System.out.println(left + " * " + right + " = "+ left * right);
                return left * right;
            case '/':
                System.out.println(left + " / " + right+ " = "+left / right);
                return left / right;
            case '+':
                System.out.println(left + " + " + right+ " = "+left + right);
                return left + right;
            case '-':
                System.out.println(left + " - " + right+ " = "+ (left - right));
                return left - right;
        }

        throw new CalculationSymbolException();
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
