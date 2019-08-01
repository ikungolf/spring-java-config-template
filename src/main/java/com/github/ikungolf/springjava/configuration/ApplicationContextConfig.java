package com.github.ikungolf.springjava.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.github.ikungolf.springjava")
@PropertySources({ @PropertySource("classpath:application.properties") })
public class ApplicationContextConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
        return config;
    }

    /**
     * 
     */

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

//    @Bean
//    public DataSource dataSource() {
//        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
//        dataSource.setJndiName("java:comp/env/jdbc/TH_HOTEL");
//        dataSource.setJndiName("jdbc/TH_HOTEL");
//        try {
//            dataSource.afterPropertiesSet();
//        } catch (IllegalArgumentException | NamingException e) {
//            throw new RuntimeException(e);
//        }
//        return (DataSource) dataSource.getObject();
//    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
