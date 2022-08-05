package code.kata.koreanclock;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class KoreanClockService {

    private final KoreaClock koreaClock;

    public KoreanClockService() {
        this.koreaClock = new KoreaClock();
        koreaClock.start();
    }

    public JSONArray findIndexList(){
        return new JSONArray(koreaClock.findPointList());
    }

}
