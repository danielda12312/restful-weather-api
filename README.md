### **Spring Boot Weather API**



A robust RESTful API service built with Spring Boot 3 that aggregates real-time meteorological data. This application consumes the OpenWeatherMap API, processes the payload using Java Records, and serves clean, structured JSON responses to clients. ( Will make a UI for the service so the clients will not have to read it as JSON. )



##### **Key Features**



* Modern HTTP Client: Utilizes Spring's synchronous RestClient (introduced in Spring Boot 3.2) for efficient external API communication.



* Clean Architecture: Strictly separates concerns into Controller (Presentation), Service (Business Logic), and Model (Data Transfer).



* Java Records: Uses immutable data structures (DTOs) for type-safe JSON mapping.



* Error Handling: Implements a GlobalExceptionHandler to gracefully manage downstream API errors (404s, Timeouts) and provide meaningful feedback to the client.



* Secure Configuration: API keys and external endpoints are externalized via application.properties.



##### **Tech Stack**



* Language: Java 25 (LTS)



* Framework: Spring Boot 3.4 (Spring Web, DevTools)



* JSON Processing: Jackson



* Build Tool: Maven



##### **Getting Started**



###### **Prerequisites**



* Java 25



* Maven (or use the included mvnw wrapper)



* An API Key from OpenWeatherMap (Free tier)





###### **Installation**



1. **Clone the repository**

   	```git clone \[https://github.com/danielda12312/restful-weather-api.git](https://github.com/danielda12312/restful-weather-api.git)
   	cd restful-weather-api```
   
2. **Configure Environment** This project uses external configuration to keep secrets safe.

   	```Rename application.properties.example to application.properties (or create a new file).

   Add your API key:

   	# src/main/resources/application.properties

   	weather.api.key=YOUR\_OPENWEATHER\_API\_KEY
   	weather.api.url=\[https://api.openweathermap.org/data/2.5/weather](https://api.openweathermap.org/data/2.5/weather)```
   
3. **Run the Application**



&nbsp;	```./mvnw spring-boot:run```





##### **API Endpoints**



The API runs on ```http://localhost:8080.```



Get Current Weather

Fetches the current weather for a specific city.



Request:

GET /weather/{city}



**Example:**



```curl http://localhost:8080/weather/London```





**Response (JSON):**



``` {

&nbsp;  "weather": \[

&nbsp;    {

&nbsp;      "description": "scattered clouds"

&nbsp;    }

&nbsp;  ],

&nbsp;  "main": {

&nbsp;    "temp": 14.5,

&nbsp;    "humidity": 72.0

&nbsp;  }

``` }









##### **Architecture**



```  User\[Client / Postman] -- GET /weather/London --> Controller\[WeatherController]

&nbsp;   Controller -- getWeather("London") --> Service\[WeatherService]

&nbsp;   Service -- API Key + City --> External\[OpenWeatherMap API]

&nbsp;   External -- Raw JSON --> Service

&nbsp;   Service -- Mapped DTO --> Controller

&nbsp;   Controller -- Clean JSON --> User  ```







##### **Future Improvements:** 



\[ ] Add a Frontend UI using Thymeleaf.



\[ ] Refactor Service to use Geocoding (Latitude/Longitude) calls instead of City Name for better precision.



\[ ] Implement caching (Redis/Caffeine) to reduce API calls.



\[ ] Add Integration Tests using MockMvc.



\[ ] Containerize with Docker.



**Created by Daniel Cherepanov**

