package com.example.servicelocatorexample.another.impl;

import com.example.servicelocatorexample.another.AnotherThing;
import org.springframework.stereotype.Component;

@Component("two")
public class TwoAnother implements AnotherThing {
    @Override
    public void doAnother() {
        System.out.println("Two another");
    }
}
