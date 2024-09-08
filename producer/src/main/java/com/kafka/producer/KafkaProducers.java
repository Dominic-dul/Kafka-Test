package com.kafka.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducers {

    private final String TOPIC_NAME = "project";

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 100; ++i){
                kafkaTemplate.send(TOPIC_NAME, "yet another message " + i);
            }
        };
    }
}
