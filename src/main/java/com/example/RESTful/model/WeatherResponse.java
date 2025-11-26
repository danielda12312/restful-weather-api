package com.example.RESTful.model;
import java.util.List;

//Used a record to reduce a lot of boilerplate code, in 1 line java writes the constructor, toString and getters.
//Its also immutable once data is passed from the API it cannot be changed "READ ONLY".
public record WeatherResponse(List<Weather> weather,Main main) {

    //Create both records to match the JSON that OpenWeatherMap sent. (look at response example in their website.)
    public record Weather(String description) {}
    public record Main(double temp, double humidity) {}
}
