package com.noveria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "config-server");
		SpringApplication.run(ConfigurationServiceApplication.class, args);
	}
}
