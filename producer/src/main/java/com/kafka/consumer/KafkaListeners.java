package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "project", groupId = "projectGroupId")
    void listener(String data) {
        System.out.println("Listener received " + data);
    }

}
