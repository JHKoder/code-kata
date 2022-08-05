package code.kata.koreanclock.web;

import code.kata.koreanclock.KoreanClockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KoreanClockApiController {

    private final KoreanClockService koreanClockService;

    public KoreanClockApiController(KoreanClockService koreanClockService) {
        this.koreanClockService = koreanClockService;
    }

    @GetMapping("api")
    public ResponseEntity<String> api() {
        return new ResponseEntity<>(koreanClockService.findIndexList().toString(), HttpStatus.OK);
    }
}
