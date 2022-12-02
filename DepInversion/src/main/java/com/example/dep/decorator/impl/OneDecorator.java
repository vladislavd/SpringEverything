package com.example.dep.decorator.impl;

import com.example.dep.decorator.Decorator;
import com.example.dep.model.decorable.Decorable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("one")
@Component
public class OneDecorator implements Decorator {
    @Override
    public void decorate(Decorable d) {
        System.out.println("One: " + d.getString());
    }
}
