package code.kata.koreanclock;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("시 테스트")
public class HourTest {

    @ParameterizedTest
    @CsvSource(value = {
            "12 ,2 2 2 4 2 5",
            "09 ,2 0 2 1 2 5",
            "01 ,0 0 2 5",
    }, delimiterString = ",")
    @DisplayName("시 괄호 테스트")
    void create(String time, String result) {
        String[][] arr = {
                {"한", "두", "세", "네", "다", "섯"},
                {"여", "섯", "일", "곱", "여", "덟"},
                {"아", "홉", "열", "한", "두", "시"}
        };

        List<String> list = List.of(result.split(" "));
        Hour hour = new Hour(arr, time);
        arr = hour.processing();

        for(int i=0;i<list.size();i+=2){
            assertThat(arr[Integer.parseInt(list.get(i))][Integer.parseInt(list.get(i+1))]).contains("[");
        }

    }

}
