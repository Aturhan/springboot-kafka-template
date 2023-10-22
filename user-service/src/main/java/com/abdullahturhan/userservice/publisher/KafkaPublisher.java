package com.abdullahturhan.userservice.publisher;

import com.abdullahturhan.userservice.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public KafkaPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String topic, User payload){
        kafkaTemplate.send(topic, payload);
    }
}
