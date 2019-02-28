package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userauthentication.domain.LoginUser;
import com.stackroute.quizify.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private UserRepository userRepository;

    @Autowired
    public Consumer(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @KafkaListener(topics = "users", groupId = "login-users-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload User payload) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("User data Received : ");
        System.out.println(payload);

        LoginUser newUser = new LoginUser();
        newUser.setUsername(payload.getUserName());
        newUser.setPassword(payload.getPassword());
        newUser.setRole("player");

        this.userRepository.save(newUser);


    }

}
