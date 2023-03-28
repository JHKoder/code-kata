package code.kata.web;

import code.kata.koreanclock.Country;
import code.kata.koreanclock.KoreanClockService;
import code.kata.koreanclock.time.Point;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KoreanClockApiController {
    private final KoreanClockService koreanClockService;

    @GetMapping("/api")
    public ResponseEntity<List<Point>> api() {
        return new ResponseEntity<>(koreanClockService.findIndexList(Country.KR), HttpStatus.OK);
    }

    @GetMapping("/{country}/api")
    public ResponseEntity<List<Point>> countryApi(@PathVariable String country) {
        return new ResponseEntity<>(koreanClockService.findIndexList(Country.findCode(country.toUpperCase())), HttpStatus.OK);
    }
}
