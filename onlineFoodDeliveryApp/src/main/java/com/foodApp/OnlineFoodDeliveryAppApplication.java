package com.foodApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.foodApp")
@Configuration
@SpringBootApplication
public class OnlineFoodDeliveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodDeliveryAppApplication.class, args);
		System.out.println("jjdj");
	}
}
