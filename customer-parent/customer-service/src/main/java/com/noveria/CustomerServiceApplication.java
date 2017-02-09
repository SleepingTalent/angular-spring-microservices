package com.noveria;

import com.noveria.configuration.CustomerServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(CustomerServiceConfiguration.class)
@ComponentScan("com.babcock.controller")
public class CustomerServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "customer-service");
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
