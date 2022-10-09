package com.example.strategyexample.service.myservice.impl;

import com.example.strategyexample.service.myservice.MyService;
import com.example.strategyexample.service.myservice.enums.ServiceType;
import org.springframework.stereotype.Component;

@Component
public class ThreeService implements MyService {
    @Override
    public ServiceType getType() {
        return ServiceType.THREE;
    }

    @Override
    public String getStatus() {
        return "ThreeService OK";
    }
}
