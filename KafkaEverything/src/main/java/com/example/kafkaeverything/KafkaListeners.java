package com.example.kafkaeverything;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "testx",
            groupId = "groupId"
    )
    public void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
