package com.example.dep.decorator.impl;

import com.example.dep.decorator.Decorator;
import com.example.dep.model.decorable.Decorable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("two")
@Component
public class TwoDecorator implements Decorator {
    @Override
    public void decorate(Decorable s) {
        System.out.println("Two: " + s.getString());
    }
}
