package com.kata.calculation;

import static com.kata.calculation.Validation.formulaVerification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    public Integer input(String str) {
        formulaVerification(str);

        List<String> operation = Arrays.stream(str.split(" "))
                .filter(ls -> Validation.isSymbol(ls.charAt(0)))
                .collect(Collectors.toUnmodifiableList());

        List<Integer> numbers = new ArrayList<>(Arrays.stream(Arrays.stream(str.split(" "))
                        .filter(Validation::isNumber)
                        .flatMapToInt(ls -> IntStream.of(Integer.parseInt(ls)))
                        .toArray())
                .boxed()
                .collect(Collectors.toUnmodifiableList()));

        return calculation(operation, numbers);
    }

    private Integer calculation(List<String> operation, List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            numbers.set(i, Operation.operation(numbers.get(i - 1), operation.get(i - 1), numbers.get(i)));
        }
        return numbers.get(numbers.size() - 1);
    }
}
