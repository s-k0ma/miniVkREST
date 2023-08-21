package ru.vkmini.back.config;


import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    @FlywayDataSource
    public DataSource flywayDataSource(DataSourceProperties properties) {
        return DataSourceBuilder.create(properties.getClassLoader())
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }
}