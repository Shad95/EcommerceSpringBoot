package com.example.Ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		// load env variables from .env file
		Dotenv dotenv = Dotenv.configure().load();ckea
		dotenv.entries().forEach(entry -> System.
						setProperty(entry.getKey(),entry.getValue()));

		SpringApplication.run(EcommerceApplication.class, args);
	}

}
