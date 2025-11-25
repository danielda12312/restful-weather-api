package com.example.RESTful.service;

import com.example.RESTful.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final String apiKey;
    private final String apiUrl;

    //Constructor injection, @Value ..
    public WeatherService(RestClient.Builder builder,
                          @Value("${weather.api.key}") String apiKey,
                          @Value("${weather.api.url}") String apiUrl) {
        this.restClient = builder.build();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public WeatherResponse getWeather(String city) {
        String finalUrl = apiUrl + "?q={city}&appid={apiKey}&units=metric" ;

        return restClient.get()
                .uri(finalUrl, city, apiKey)
                .retrieve()
                .body(WeatherResponse.class);
    }
}
