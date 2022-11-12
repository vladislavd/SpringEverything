package com.example.servicelocatorexample;

import com.example.servicelocatorexample.constants.ContentType;
import com.example.servicelocatorexample.manager.ParserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ServiceLocatorExampleApplication implements CommandLineRunner {

    private final ParserManager manager;

    public static void main(String[] args) {
        SpringApplication.run(ServiceLocatorExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("manager.parse(\"input for json\", ContentType.JSON_PARSER) = " + manager.parse("input for json", ContentType.JSON));
        System.out.println("manager.parse(\"input for xml\", ContentType.XML_PARSER) = " + manager.parse("input for xml", ContentType.XML));

        manager.doAnother();
    }
}
