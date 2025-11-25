package com.example.RESTful.model;
import java.util.List;

public record WeatherResponse(List<Weather> weather,Main main) {

    public record Weather(String description) {}

    public record Main(double temp, double humidity) {}
}
