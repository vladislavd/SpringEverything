package com.example.chainofresponsibility.service.manager;

import com.example.chainofresponsibility.service.handler.Handler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class HandlerUser {

    private final List<Handler> handlers;

    public void doWork() {
        handlers.forEach(Handler::handle);
    }
}
