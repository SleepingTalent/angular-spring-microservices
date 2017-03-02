package com.noveria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistrationServiceApplication.class, args);
	}
}
