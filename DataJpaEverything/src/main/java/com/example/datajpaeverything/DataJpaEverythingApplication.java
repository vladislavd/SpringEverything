package com.example.datajpaeverything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class DataJpaEverythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaEverythingApplication.class, args);
    }

}
