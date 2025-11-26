package com.example.RESTful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

	//This method will instantiate, configure, and initialize an object that Spring will then manage
	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

}
