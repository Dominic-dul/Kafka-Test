package com.producer.controller;

import com.producer.model.MyMsg;
import com.producer.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private final KafkaProducerService kafkaProducerService;

    public ProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
    @PostMapping(value = "/produce")
    public ResponseEntity<Boolean> produce(@RequestBody MyMsg myMsg) {
        try {
            kafkaProducerService.send("new-topic", myMsg);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception ex) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
}
