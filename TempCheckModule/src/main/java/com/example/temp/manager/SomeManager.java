package com.example.temp.manager;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class SomeManager {

    public Map<String, String> parseData(String data) {
        Map<String, String> result = new TreeMap<>();
        String DELIMITER = "\\|";
        for (String s : data.split(DELIMITER)) {
            String KEY_VALUE_DELIMITER = "=";
            String[] split = s.split(KEY_VALUE_DELIMITER);
            result.put(split[0].trim(), (split.length == 1) ? Strings.EMPTY : split[1].trim());
        }

        return result;
    }
}
