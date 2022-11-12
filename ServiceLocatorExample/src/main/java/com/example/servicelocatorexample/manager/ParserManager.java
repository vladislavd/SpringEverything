package com.example.servicelocatorexample.manager;

import com.example.servicelocatorexample.another.AnotherFactory;
import com.example.servicelocatorexample.constants.ContentType;
import com.example.servicelocatorexample.parser.Parser;
import com.example.servicelocatorexample.parser.ParserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParserManager {

    private final ParserFactory factory;
    private final AnotherFactory anotherFactory;

    public List<String> parse(String input, ContentType type) {
        Parser parser = factory.getParser(type);
        return parser.parse(input);


    }
    public void doAnother() {
        anotherFactory.getAnotherThing("one").doAnother();
        anotherFactory.getAnotherThing("two").doAnother();
    }

}
