package com.example.dep.manager;

import com.example.dep.decorator.Decorator;
import com.example.dep.model.decorable.impl.One;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OneManager {

    private final Decorator decorator;


    public void doDecoration() {
        One one = new One();
        one.setString("one decorable");
        decorator.decorate(one);
    }
}
