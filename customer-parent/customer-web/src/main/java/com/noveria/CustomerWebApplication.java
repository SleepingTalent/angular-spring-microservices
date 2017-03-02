package com.noveria;

import com.noveria.configuration.WebSocketConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import(WebSocketConfiguration.class)
public class CustomerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebApplication.class, args);
	}

}
