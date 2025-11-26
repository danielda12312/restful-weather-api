package com.example.RESTful.controller;

import com.example.RESTful.model.WeatherResponse;
import com.example.RESTful.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    /*constructor injection, when an instance of weatherController is made spring makes the WeatherService bean
      and passes it as an argument to the WeatherController constructor*/
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /*Map the HTTP GET method the WeatherResponse method in other words it  designates a method to handle incoming
      HTTP GET requests for a defined URL path*/
    @GetMapping("/weather/{city}")
    public WeatherResponse checkWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
