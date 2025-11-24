package com.example.RESTful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    private String index()
    {
        return "Greetings!";
    }
}
