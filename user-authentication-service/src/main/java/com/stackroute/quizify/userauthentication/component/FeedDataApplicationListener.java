package com.stackroute.quizify.userauthentication.component;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userauthentication.domain.LoginUser;
import com.stackroute.quizify.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
//@Data
//@Primary
//@Configuration
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private UserRepository userRepository;

    private Producer producer;
    @Autowired
    public FeedDataApplicationListener(UserRepository userRepository, Producer producer){
        this.userRepository=userRepository;
        this.producer = producer;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        userRepository.save(new LoginUser("admin", "123", "admin"));
        userRepository.save(new LoginUser("player1", "123", "player"));
        userRepository.save(new LoginUser("player2", "123", "player"));
        userRepository.save(new LoginUser("player3", "123", "player"));

        User user = new User();
        user.setUserId(101);
        user.setUserName("kaustav");
        user.setEmailId("kaustavlogan@gmail.com");
        user.setPassword("123456789");
        user.setGender("Male");
        user.setInterests(null);

        producer.send(user);

    }


}
