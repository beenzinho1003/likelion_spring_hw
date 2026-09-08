package com.example.springhomework.greeting.controller;

import com.example.springhomework.greeting.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet(
            @RequestParam String name,
            @RequestParam int hour
    ) {
        return greetingService.greet(name, hour);
    }

    @GetMapping("/messages/count")
    public int count() {
        return greetingService.count();
    }
}