package code.kata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class KoreanClockController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/kr")
    public String krHome() {
        return "index";
    }
    @GetMapping("/de")
    public String deHome() {
        return "index";
    }
    @GetMapping("/hk")
    public String hkHome() {
        return "index";
    }
    @GetMapping("/nz")
    public String nzHome() {
        return "index";
    }
    @GetMapping("/us")
    public String usHome() {
        return "index";
    }
    @GetMapping("/jp")
    public String jpHome() {
        return "index";
    }

}
