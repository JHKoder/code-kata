package code.kata.koreanclock;

import code.kata.koreanclock.time.Point;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KoreanClockService {
    private final KoreaClock koreaClock;

    public List<Point> findIndexList(Country code) {
        return koreaClock.findPointList(code);
    }
}
