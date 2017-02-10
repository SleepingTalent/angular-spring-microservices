package com.noveria;

import com.noveria.cukes.configuration.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(TestConfiguration.class)
@ComponentScan({"com.noveria.controller","com.noveria.cukes"})
public class TestApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "test-customer-service");
        SpringApplication.run(TestApplication.class, args);
    }
}
