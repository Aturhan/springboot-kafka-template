package com.abdullahturhan.accountservice.consumer;

import com.abdullahturhan.accountservice.dto.AccountDto;
import com.abdullahturhan.accountservice.dto.UserCreateEvent;
import com.abdullahturhan.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    private final AccountService accountService;

    public KafkaConsumer(AccountService accountService) {
        this.accountService = accountService;
    }
    @KafkaListener(topics = "${kafka.topics.user-created.topic}",groupId = "${kafka.topics.user-created.consumerGroup}",
           containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void listener(@Payload UserCreateEvent event){ //if it does not work,look ConsumerRecord @Headers ConsumerRecord<String ,Object> consumerRecord
        try {
            log.info(String.format("Event received => %s", event));
            accountService.createAccount(event);
        }catch (Exception e){
            log.error(String.format("Error occurred while saving account => %s ",e.getMessage()));
        }

    }
}
