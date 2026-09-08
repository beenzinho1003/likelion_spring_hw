package com.example.springhomework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyNameController {

    @GetMapping("/my-name")
    public String myName() {
        return "진호장";
    }
}