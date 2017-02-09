package com.noveria.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EntityScan("com.babcock.model.customer")
@EnableJpaRepositories("com.babcock.model.customer")
@PropertySource("classpath:db-config.properties")
public class CustomerServiceConfiguration {

    protected Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Creates an in-memory database populated with test data for fast testing
     */
    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");

        // Create an in-memory H2 relational database containing some demo data
        DataSource dataSource = (new EmbeddedDatabaseBuilder())
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:testdb/schema.sql")
                .addScript("classpath:testdb/data.sql").build();

        runSanityCheck(dataSource);

        return dataSource;
    }

    private void runSanityCheck(DataSource dataSource) {
        String sql = "SELECT count(*) from CUSTOMERS";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        logger.info("System has " + count + " customers pre-loaded");
    }
}
