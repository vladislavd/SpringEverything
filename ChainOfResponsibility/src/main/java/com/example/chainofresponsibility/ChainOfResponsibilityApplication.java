package com.example.chainofresponsibility;

import com.example.chainofresponsibility.service.manager.HandlerUser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ChainOfResponsibilityApplication implements CommandLineRunner {

    private final HandlerUser handlerUser;
    public static void main(String[] args) {
        SpringApplication.run(ChainOfResponsibilityApplication.class, args);
    }

    @Override
    public void run(String... args) {
       handlerUser.doWork();
    }
}
