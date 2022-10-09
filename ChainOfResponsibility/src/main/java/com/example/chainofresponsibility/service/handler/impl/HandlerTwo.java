package com.example.chainofresponsibility.service.handler.impl;

import com.example.chainofresponsibility.service.handler.Handler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class HandlerTwo implements Handler {
    @Override
    public void handle() {
        System.out.println("HandlerTwo handles");
    }
}
