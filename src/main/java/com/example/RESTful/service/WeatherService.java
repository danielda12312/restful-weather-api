package com.example.RESTful.service;

import com.example.RESTful.model.GeoResponse;
import com.example.RESTful.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final String apiKey;
    private final String apiUrl;
    private final GeoService geoService;


    /*Constructor injection, @Value simply takes the value from the application.properties and passes it to the
      specified variable.*/
    public WeatherService(RestClient.Builder builder,
                          @Value("${weather.api.key}") String apiKey,
                          @Value("${weather.api.url}") String apiUrl,
                          GeoService geoService) {
        this.restClient = builder.build();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.geoService = geoService;
    }

    //This is the method that is the "translator" between my java code and OpenWeatherMap servers.
    public WeatherResponse getWeather(String city) {

        //Now I get latitude and longitude instead of city name.
        String finalUrl = apiUrl + "?lat={lat}&lon={lon}&appid={apiKey}&units=metric";

        GeoResponse coordinates = geoService.getCoordinates(city);

        //.get specify HOW we want to talk to the server (if I want to save data to a DB I will use .post)
        return restClient.get()
                .uri(finalUrl, coordinates.lat(), coordinates.lon(), apiKey)

                //This is where we fire the request, we sent the request and wait for a response
                .retrieve()

                /*The API sends back a massive JSON text, and this line tells Spring take it and force it into
                 the shape of my WeatherResponse class.*/
                .body(WeatherResponse.class);
    }
}
