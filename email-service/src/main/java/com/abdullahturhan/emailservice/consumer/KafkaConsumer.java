package com.abdullahturhan.emailservice.consumer;

import com.abdullahturhan.emailservice.dto.UserCreateEvent;
import com.abdullahturhan.emailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    private final EmailService emailService;

    public KafkaConsumer(EmailService emailService) {
        this.emailService = emailService;
    }
    @KafkaListener(topics = "${kafka.topics.user-created.topic}",groupId = "${kafka.topics.user-created.consumerGroup}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listener(@Payload UserCreateEvent event){
        log.info(String.format("Event received successfully => %s",event.toString()));
        try {
            emailService.sedMail(event);
        }catch (Exception e){
            log.error("Exception occurred when sending email " +e.getMessage());
        }
    }
}
