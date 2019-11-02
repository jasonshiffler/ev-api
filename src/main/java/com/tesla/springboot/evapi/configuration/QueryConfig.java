package com.tesla.springboot.evapi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class QueryConfig {

    @Value("${query.defaultsize:25}")
    private int defaultQuerySize;

    @Value("${query.maxquerysize:1000}")
    private int maxQuerySize;

    /**
     * Injects the maximum possible query size into a Bean called maxQuerySize
     */
    @Bean
    public int maxQuerySize(){
        return maxQuerySize;
    }

    /**
     * Injects the default query size into a Bean called defaultQuerySize
     */
    @Bean
    public int defaultQuerySize(){
        return defaultQuerySize;
    }

}
