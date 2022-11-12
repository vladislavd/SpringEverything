package com.example.servicelocatorexample.parser.impl;

import com.example.servicelocatorexample.constants.ParserNames;
import com.example.servicelocatorexample.parser.Parser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(ParserNames.JSON_PARSER)
public class JsonParser implements Parser {
    @Override
    public List<String> parse(String input) {
        return List.of("JSON " + input);
    }
}
