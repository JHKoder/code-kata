package com.kata.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    public Integer practice(String str) {

        List<String> strings = Arrays.stream(str.split(" "))
                .collect(Collectors.toUnmodifiableList());

        List<String> operation = strings.stream()
                .filter(Validation::isSymbol)
                .collect(Collectors.toUnmodifiableList());

        List<Integer> numbers = new ArrayList<>(strings.stream()
                .filter(Validation::isNumber)
                .flatMapToInt(ls -> IntStream.of(Integer.parseInt(ls)))
                .boxed()
                .collect(Collectors.toUnmodifiableList()));

        return Operation.calculation(operation, numbers);
    }
}
