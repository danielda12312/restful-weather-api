package com.example.RESTful.service;

import com.example.RESTful.model.GeoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GeoService {

    private final RestClient restClient;
    private final String apiKey;
    private final String geoUrl;

    public GeoService(RestClient.Builder builder,
                      @Value("${weather.api.key}") String apiKey,
                      @Value("${geo.api.url}") String geoUrl) {
        this.restClient = builder.build();
        this.geoUrl = geoUrl;
        this.apiKey = apiKey;
    }

    public GeoResponse getCoordinates(String city) {
        String finalUrl = geoUrl + "?q={city}&limit=1&appid={apiKey}";

        GeoResponse[] results = restClient.get()
                .uri(finalUrl, city, apiKey)
                .retrieve()
                .body(GeoResponse[].class);

        if(results == null || results.length == 0) {
            throw new RuntimeException("City not found" + city);
        }

        return results[0];
    }
}
