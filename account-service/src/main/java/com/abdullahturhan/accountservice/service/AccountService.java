package com.abdullahturhan.accountservice.service;

import com.abdullahturhan.accountservice.dto.UserCreateEvent;
import com.abdullahturhan.accountservice.model.Account;
import com.abdullahturhan.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(UserCreateEvent event){
        final Account account = Account.builder()
                .user_id(event.getId())
                .user_firstname(event.getFirstName())
                .user_lastname(event.getLastName())
                .user_email(event.getEmail())
                .balance(100.00)
                .build();
        accountRepository.save(account);
        log.info(String.format("Account saved successfully => %s ",account));
    }
}
