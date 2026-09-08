package com.gopu.github.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
@ComponentScan("com.gopu.github")
public class AppConfig {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
