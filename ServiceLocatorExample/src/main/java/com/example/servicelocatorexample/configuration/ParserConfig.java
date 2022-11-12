package com.example.servicelocatorexample.configuration;

import com.example.servicelocatorexample.another.AnotherFactory;
import com.example.servicelocatorexample.parser.ParserFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfig {


    @Bean("parserFactory")
    public FactoryBean serviceLocatorParserFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(ParserFactory.class);
        return factoryBean;
    }

    @Bean("anotherFactory")
    public FactoryBean serviceLocatorAnotherFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(AnotherFactory.class);
        return factoryBean;
    }
}
