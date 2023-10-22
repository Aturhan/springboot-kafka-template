package com.abdullahturhan.emailservice.service;

import com.abdullahturhan.emailservice.dto.UserCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    public void sedMail(UserCreateEvent event){
        log.info(String.format("Email sent to => %s",event.getEmail()));
    }
}
