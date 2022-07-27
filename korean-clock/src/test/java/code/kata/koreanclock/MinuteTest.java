package code.kata.koreanclock;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MinuteTest {

    @ParameterizedTest
    @CsvSource(value = {
            "59 ,3 4 3 5 5 4 5 5",
            "30 ,3 2 3 5 5 5",
            "01 ,4 1 5 5",
    }, delimiterString = ",")
    @DisplayName("분 괄호 테스트")
    void create(String time, String result) {
        String[][] arr = {
                {"한", "두", "세", "네", "다", "섯"},
                {"여", "섯", "일", "곱", "여", "덟"},
                {"아", "홉", "열", "한", "두", "시"},
                {"자", "이", "삼", "사", "오", "십"},
                {"정", "징", "이", "삼", "사", "육"},
                {"오", "오", "칠", "팔", "구", "분"}
        };

        List<String> list = List.of(result.split(" "));
        Minute hour = new Minute(arr, time);
        arr = hour.processing();

        for (int i = 0; i < list.size(); i += 2) {
            assertThat(arr[Integer.parseInt(list.get(i))][Integer.parseInt(list.get(i + 1))]).contains("[");
        }

    }
}
