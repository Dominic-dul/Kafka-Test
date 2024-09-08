package com.consumer.service;

import com.consumer.model.MyMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {
    @KafkaListener(topics = {"new-topic"}, groupId = "topic-name")
    public void consume(MyMsg myMsg) {
        log.info(String.format("Received: " + myMsg));
    }
}
