package com.noveria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerWebApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "customer-web");
		SpringApplication.run(CustomerWebApplication.class, args);
	}

}
