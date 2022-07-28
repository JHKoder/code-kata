package code.kata.koreanclock;

import static java.util.Arrays.stream;

import java.util.Objects;
import java.util.stream.Stream;

public class Korea {

    private String[][] arr = {
            {" 한 ", " 두 ", " 세 ", " 네 ", " 다 ", " 섯 "},
            {" 여 ", " 섯 ", " 일 ", " 곱 ", " 여 ", " 덟 "},
            {" 아 ", " 홉 ", " 열 ", " 한 ", " 두 ", " 시 "},
            {" 자 ", " 이 ", " 삼 ", " 사 ", " 오 ", " 십 "},
            {" 정 ", " 일 ", " 이 ", " 삼 ", " 사 ", " 육 "},
            {" 오 ", " 오 ", " 칠 ", " 팔 ", " 구 ", " 분 "}
    };

    public void gettingItRight(String hour, String minute, int hours) {

        if (Objects.equals(hour, "00") && Objects.equals(minute, "00")) {
            new Meridian(arr, hours).processing();
            return;
        }

        new Hour(arr, hour).processing();
        new Minute(arr, minute).processing();
    }

    public void print() {
        System.out.print("\n".repeat(5));
        stream(arr).flatMap(this::newLineStream).forEach(System.out::print);
    }

    private <T> Stream<T> newLineStream(T[] array) {
        System.out.print("\n");
        return stream(array, 0, array.length);
    }

}
