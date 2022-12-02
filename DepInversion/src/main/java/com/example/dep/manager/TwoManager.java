package com.example.dep.manager;

import com.example.dep.decorator.Decorator;
import com.example.dep.model.decorable.impl.Two;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TwoManager {

    private final Decorator decorator;


    public void doDecoration() {
        Two two = new Two();
        two.setString("two decorable");
        decorator.decorate(two);
    }
}
