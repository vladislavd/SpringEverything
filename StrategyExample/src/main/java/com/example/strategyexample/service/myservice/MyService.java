package com.example.strategyexample.service.myservice;

import com.example.strategyexample.service.myservice.enums.ServiceType;

public interface MyService {
    ServiceType getType();
    String getStatus();
}
