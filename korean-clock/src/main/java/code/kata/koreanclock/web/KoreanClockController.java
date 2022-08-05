package code.kata.koreanclock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KoreanClockController {

    @GetMapping
    public String home() {
        return "index";
    }

}
