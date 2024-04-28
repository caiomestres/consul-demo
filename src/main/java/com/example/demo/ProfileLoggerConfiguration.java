package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
public class ProfileLoggerConfiguration {

    @Bean
    public CommandLineRunner printActiveProfiles(Environment environment) {
        return args -> {
            System.out.println("Currently active profiles: " + Arrays.toString(environment.getActiveProfiles()));
        };
    }
}
