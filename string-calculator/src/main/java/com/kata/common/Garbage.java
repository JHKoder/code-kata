package com.kata.common;

import com.kata.calculation.numbers.OperationTree;
import java.util.Arrays;

public class Garbage {

    public static void remove(Object obj) {
        obj = null;
    }

    public static void remove(OperationTree ott) {
        ott = null;
    }

    public static void remove(OperationTree... ott) {
        Arrays.fill(ott, null);
    }
}
