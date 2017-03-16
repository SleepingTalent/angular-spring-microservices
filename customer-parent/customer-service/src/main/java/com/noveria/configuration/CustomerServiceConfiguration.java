package com.noveria.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EntityScan("com.noveria.model.customer")
@EnableJpaRepositories("com.noveria.model.customer")
@PropertySource("classpath:db-config.properties")
public class CustomerServiceConfiguration {

    private Logger logger = Logger.getLogger(getClass().getName());

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

//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedHeader("OPTIONS");
//        config.addAllowedHeader("HEAD");
//        config.addAllowedHeader("GET");
//        config.addAllowedHeader("PUT");
//        config.addAllowedHeader("POST");
//        config.addAllowedHeader("DELETE");
//        config.addAllowedHeader("PATCH");
//
//        source.registerCorsConfiguration("/**", config);
//
//        //return new CorsFilter(source);
//
//        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//
//    }

//    DataSource if using mySql db

//    @Bean
//    public DataSource dataSource() {
//        logger.info("dataSource() invoked");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://10.52.180.26:3306/dev");
//        dataSource.setUsername("dev");
//        dataSource.setPassword("password");
//
//        return dataSource;
//    }

    private void runSanityCheck(DataSource dataSource) {
        String sql = "SELECT count(*) from CUSTOMERS";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        logger.info("System has " + count + " customers pre-loaded");
    }
}
