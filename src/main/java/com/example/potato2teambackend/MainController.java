package com.example.potato2teambackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
