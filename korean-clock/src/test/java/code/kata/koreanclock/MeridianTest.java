package code.kata.koreanclock;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("자오정 테스트")
public class MeridianTest {

    @ParameterizedTest
    @CsvSource(value = {
            "00 ,4 0 3 0",
            "12 ,4 0 5 0"
    }, delimiterString = ",")
    @DisplayName("자오정 테스트")
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

        Meridian meridian = new Meridian(arr, Integer.parseInt(time));
        arr= meridian.processing();

        for (int i = 0; i < list.size(); i += 2) {
            assertThat(arr[Integer.parseInt(list.get(i))][Integer.parseInt(list.get(i + 1))]).contains("[");
        }

    }
}
