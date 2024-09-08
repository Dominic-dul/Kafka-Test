package com.producer.service;

import com.producer.model.MyMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, MyMsg> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, MyMsg> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void send(String topicName, MyMsg value) {
        var future = kafkaTemplate.send(topicName, value);
        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info(String.format("Task status send to Kafka topic : %s, Object: ", topicName)+ value);
        });
    }
}
