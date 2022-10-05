package com.example.demo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value = "/hello", produces = "application/json")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
