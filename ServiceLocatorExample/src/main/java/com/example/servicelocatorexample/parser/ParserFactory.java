package com.example.servicelocatorexample.parser;

import com.example.servicelocatorexample.constants.ContentType;

public interface ParserFactory {
    Parser getParser(ContentType type);
}

