package com.greenlightplanet.got;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = 
{"com.greenlightplanet.got", "com.greenlightplanet.got.model", "com.greenlightplanet.got.repository", "com.greenlightplanet.got.service", "com.greenlightplanet.got.service.impl"})
public class GameOfThronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfThronesApplication.class, args);
	}

}
