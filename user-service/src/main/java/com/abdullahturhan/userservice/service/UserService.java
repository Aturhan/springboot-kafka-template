package com.abdullahturhan.userservice.service;


import com.abdullahturhan.userservice.dto.UserDto;
import com.abdullahturhan.userservice.model.User;
import com.abdullahturhan.userservice.publisher.KafkaPublisher;
import com.abdullahturhan.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final KafkaPublisher kafkaPublisher;

    public UserService(UserRepository userRepository, KafkaPublisher kafkaPublisher) {
        this.userRepository = userRepository;
        this.kafkaPublisher = kafkaPublisher;
    }

    public void createUser(UserDto userDto){
      final User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
      final User fromDb = userRepository.save(user);
        log.info("User saved successfully=> " + user.toString());

        kafkaPublisher.publish("user_created",fromDb);
        log.info("User sent successfully=> %s" + fromDb.toString());
    }
}
