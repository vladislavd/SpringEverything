package com.example.servicelocatorexample.parser.impl;

import com.example.servicelocatorexample.constants.ParserNames;
import com.example.servicelocatorexample.parser.Parser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(ParserNames.XML_PARSER)
public class XmlParser implements Parser {
    @Override
    public List<String> parse(String input) {
        return List.of("XML" + input);
    }
}
