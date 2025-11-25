package com.example.RESTful.service;

import com.example.RESTful.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final String API_KEY = "MY_API_KEY";

    public WeatherService(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

    public WeatherResponse getWeather(String city) {
        return restClient.get()
                .uri("https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric", city, API_KEY)
                .retrieve()
                .body(WeatherResponse.class);
    }
}
