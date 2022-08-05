package code.kata.koreanclock.netty;

import code.kata.koreanclock.Korea;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.json.JSONArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("json 형식 형변환이 가능하다.")
public class JsonTest {


    @Test
    void koreanClockIndexListToJson() throws JsonMappingException {
        Korea korea = new Korea();
        korea.processing(1, 1); // 1 시 1 분
        JSONArray jsonArray = new JSONArray(korea.findPointList());
        System.out.println(jsonArray);
    }
}
