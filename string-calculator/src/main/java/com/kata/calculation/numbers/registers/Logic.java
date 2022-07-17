package com.kata.calculation.numbers.registers;

import com.kata.calculation.numbers.Register;
import com.kata.common.Log;
import java.util.Objects;

public class Logic {

    //연산
    public void operation(Register register) {
        Register find = Register.control.findFastOperation(register);

        if (Objects.equals(find.operator, ')')) {
            Log.info("( ) 병합");
            Control.removeParentheses(find.left.left, find.left, find);
        } else {
            if (find.left != null) {
                Control.processing(find.left, find, find.next);
            } else {
                return;
            }
        }

        if (register.next != null) {
            operation(register);
        }
    }
}
