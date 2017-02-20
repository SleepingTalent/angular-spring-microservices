package com.noveria.cukes.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EntityScan("com.noveria.model.customer")
@EnableJpaRepositories("com.noveria.model.customer")
@PropertySource("classpath:test-db-config.properties")
public class TestConfiguration {

    @Bean
    public DataSource dataSource() {
        return (new EmbeddedDatabaseBuilder())
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
}
