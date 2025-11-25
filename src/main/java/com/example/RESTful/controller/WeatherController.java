package com.example.RESTful.controller;

import com.example.RESTful.model.WeatherResponse;
import com.example.RESTful.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    //constructor injection.
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public WeatherResponse checkWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
