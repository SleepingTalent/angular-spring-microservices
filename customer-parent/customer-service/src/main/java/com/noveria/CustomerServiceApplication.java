package com.noveria;

import com.noveria.configuration.CustomerServiceConfiguration;
import com.noveria.configuration.SecurityConfiguration;
import com.noveria.configuration.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@Import({SecurityConfiguration.class,CustomerServiceConfiguration.class,SwaggerConfiguration.class})
@ComponentScan("com.noveria.controller")
public class CustomerServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "customer-service");
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
