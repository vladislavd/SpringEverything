package com.example.temp.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


@SpringBootTest
class SomeManagerTest {

    @Autowired
    private SomeManager someManager;

    @ParameterizedTest
    @MethodSource("dataForParsing")
    void parseData(String data, Map<String, String> expected) {
        Map<String, String> actual = someManager.parseData(data);
        Assertions.assertEquals(expected, actual);
    }


    private static Stream<Arguments> dataForParsing() {

        return Stream.of(
                Arguments.of("name=vasya|age=20",
                        fillMap(new LinkedHashMap<>(), List.of("name", "vasya", "age", "20"))),
                Arguments.of("name= vasya|age= 20",
                        fillMap(new LinkedHashMap<>(), List.of("name", "vasya", "age", "20"))),
                Arguments.of("name|age=20",
                        fillMap(new LinkedHashMap<>(), List.of("name", "", "age", "20")))
        );
    }

    private static Map<String, String> fillMap(Map<String, String> map, List<String> data) {
        for (int i = 0; i < data.size(); i += 2) {
            map.put(data.get(i), data.get(i + 1));
        }
        return map;
    }
}