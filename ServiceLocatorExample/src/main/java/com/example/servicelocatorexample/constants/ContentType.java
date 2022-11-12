package com.example.servicelocatorexample.constants;

import lombok.RequiredArgsConstructor;

import static com.example.servicelocatorexample.constants.ParserNames.JSON_PARSER;
import static com.example.servicelocatorexample.constants.ParserNames.XML_PARSER;

@RequiredArgsConstructor
public enum ContentType {
    XML(XML_PARSER),
    JSON(JSON_PARSER);

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
