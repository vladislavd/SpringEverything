package com.example.chainofresponsibility.service.handler.impl;

import com.example.chainofresponsibility.service.handler.Handler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class HandlerOne implements Handler {
    @Override
    public void handle() {
        System.out.println("HandlerOne handles");
    }
}
