package com.example.strategyexample.service.myservice.impl;

import com.example.strategyexample.service.myservice.MyService;
import com.example.strategyexample.service.myservice.enums.ServiceType;
import org.springframework.stereotype.Component;

@Component
public class OneService implements MyService {
    @Override
    public ServiceType getType() {
        return ServiceType.ONE;
    }

    @Override
    public String getStatus() {
        return "OneService OK";
    }
}
