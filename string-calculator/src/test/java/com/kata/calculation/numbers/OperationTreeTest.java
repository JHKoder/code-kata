package com.kata.calculation.numbers;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 계산기 자료구조 테스트")
public class OperationTreeTest {

    @Test
    void 자료구조_사용법() {
        OperationTree oper = new OperationTree();
        //입력
        oper.append(1);
        oper.append('+');
        oper.append(1);

        //계산
        oper.operation();

        //계산값 리턴
        Assertions.assertThat(oper.findTree()).isEqualTo(2);
    }

}

