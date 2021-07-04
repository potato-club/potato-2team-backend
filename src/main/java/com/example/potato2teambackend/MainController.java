package com.example.potato2teambackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/api/v1/ping")
    public String ping() {
        return "pong";
    }
}
