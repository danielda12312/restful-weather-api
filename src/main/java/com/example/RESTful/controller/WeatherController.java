package com.example.RESTful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/weather")
    private String getWeather()
    {
        return "123";
    }
}
