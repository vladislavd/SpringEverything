package com.example.servicelocatorexample.another.impl;

import com.example.servicelocatorexample.another.AnotherThing;
import org.springframework.stereotype.Component;

@Component("one")
public class AnotherOne implements AnotherThing {
    @Override
    public void doAnother() {
        System.out.println("ONE ANOTHER");
    }
}
