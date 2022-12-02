package com.example.dep;

import com.example.dep.manager.OneManager;
import com.example.dep.manager.TwoManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepInversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepInversionApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(OneManager oneManager, TwoManager twoManager) {
        return args -> {
           oneManager.doDecoration();
           twoManager.doDecoration();
        };
    }
}
