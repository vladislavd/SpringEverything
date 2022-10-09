package com.example.strategyexample;

import com.example.strategyexample.service.myservice.MyService;
import com.example.strategyexample.service.myservice.MyServiceFactory;
import com.example.strategyexample.service.myservice.enums.ServiceType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyExampleApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(StrategyExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MyService three = MyServiceFactory.getService(ServiceType.THREE);
        System.out.println("three = " + three.getStatus());
        MyService two = MyServiceFactory.getService(ServiceType.TWO);
        System.out.println("two = " + two.getStatus());
        MyService one = MyServiceFactory.getService(ServiceType.ONE);
        System.out.println("one = " + one.getStatus());

    }
}
