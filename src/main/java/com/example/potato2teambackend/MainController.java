package com.example.potato2teambackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/home")
    public String home() {
        return "index.html";
    }

}
