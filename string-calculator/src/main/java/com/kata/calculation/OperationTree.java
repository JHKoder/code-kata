package com.kata.calculation;

import com.kata.exception.CalculationFailureException;
import java.util.Objects;

public class OperationTree {

    public OperationTree next = null;
    public OperationTree left = null;

    public Long index;
    public double value;
    public String operator;

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
            next.left = this;
        } else {
            next.append(sp);
        }

    }

    public void operation() {
        OperationTree find = findFastOperation();

        if (Objects.equals(find.operator, ")")) {
            System.out.println("( ) 병합");
            removeParentheses(find.left.left, find.left, find);
        } else {
            if (find.left != null) {
                processing(find.left, find, find.next);
                System.out.println(" = " + find.left.value);
            } else {
                return;
            }
        }

        if (next != null) {
            operation();
        }

    }

    //left - right 으로 병합
    public void processing(OperationTree left, OperationTree oper, OperationTree right) {

        double sum = arithmetic(left.value, oper.operator.charAt(0), right.value);

        left.value = sum;
        if (right.next != null) {
            left.next = right.next;
            right.next.left = left;
        } else {
            left.next = null;
        }

        oper = null;
    }


    // ( a )  에서 a 만 남기는
    public OperationTree removeParentheses(OperationTree left, OperationTree find, OperationTree right) {

        //( 처리
        if (left.left != null) {
            // ( 왼쪽에 연산자가 있을경우
            left.left.next=find;
            find.left=left.left;
            left = null;
        }else{
            find.left=null;
            left=find;
        }

        // ) 처리
        if (right.next != null) {
            // ) 오른쪽에 연산자가 있을경우
            right.next.left = find;
            find.next=right.next;
            right =null;
        } else {
            find.next=null;
            right=null;
        }

        return find;
    }

    //"(" 을 만날떄까지의 최우선순위 구하는 함수
    public OperationTree findLeftOperation(OperationTree find, int min, OperationTree save) {

        // ) 이 left 해서 null 을 만난다면 연산자의 오류가 아닐까?
        // ) 이 ( 을 만나기 위해 만든 메소드인대 못찾으면 오류가 일어나는게 당연한것 같다.
        if (find == null) {
            return save;
        }
        //반복문의 끝

        if (Objects.equals(find.operator, "(")) {
            //우선순위가 가장 높은 객체 리턴
            return save;

        } else {
            //현재 연산자 가져오기

            if (find.operator == null) {
                // left 가 존재하는대 연산자가 아닐경우
                return findLeftOperation(find.left, min, save);

            } else {
                //찾는 연산자 우선순위 넘버 가져오기
                int priorityNum = prioritySymbol(find.operator.charAt(0));

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


    public OperationTree findFastOperation() {
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
    public OperationTree findFastOperation(OperationTree find, int min, OperationTree save) {

        // 다음 주소값이 존재 하면 true
        if (find.next != null) {

            //연산자가 아닐경우
            if (find.operator == null) {
                return findFastOperation(find.next, min, save);
            }

            //연산자의 우선순위 비교시 숫자 가져오기
            int findNum = priority(find.operator.charAt(0));

            // 연산자가 ")" 일떄
            if (findNum == 1) {
                // ")" 을 만났을때 "(" 을 만날떄까지 left 를 만날떄까지 반복
                System.out.println("left find -");
                findTree();
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

    public double arithmetic(double left, char ch, double right) {
        switch (ch) {
            case '*':
                System.out.print(left + " * " + right);
                return left * right;
            case '/':
                System.out.print(left + " / " + right);
                return left / right;
            case '+':
                System.out.print(left + " + " + right);
                return left + right;
            case '-':
                System.out.print(left + " - " + right);
                return left - right;
        }

        throw new CalculationFailureException();
    }

    public boolean isFindOperator(String oper) {
        if (next != null) {
            if (Objects.equals(operator, oper)) {
                return true;
            }
            return next.isFindOperator(oper);
        }
        return false;
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

    public int prioritySymbol(char operator) {

        switch (operator) {
            case '*':
                return 1;
            case '/':
                return 2;
            case '+':
                return 3;
            case '-':
                return 4;
        }
        return 10;
    }

    public int priority(char operator) {

        switch (operator) {
            case ')':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '+':
                return 4;
            case '-':
                return 5;
        }
        return 10;
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
        long re = 0;
        int me = 0;

        if (str.charAt(0) == '-') {
            me = 1;
        }
        for (int i = me; i < str.length(); i++) {
            re += str.charAt(i) - '0';

            if (i == str.length() - 1) {
                break;
            }

            re *= 10;
        }
        if (me == 1) {
            re *= -1;
        }
        return re;
    }


}
