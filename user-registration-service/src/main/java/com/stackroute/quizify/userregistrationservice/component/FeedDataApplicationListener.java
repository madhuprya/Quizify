package com.stackroute.quizify.userregistrationservice.component;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userregistrationservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private Producer producer;
    @Autowired
    public FeedDataApplicationListener(UserService userService, Producer producer) {
        this.userService = userService;
        this.producer = producer;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        userRepository.save(new User("1122","akhila","ak123","ak123", "akhila@gmail.com", ["Movies", "TV Shows"], "F"));
//        userRepository.save(new User("2244","akhil","hello1","hello1", "akhila@gmail.com", {("Movies"), ("TvShows")},"M"));
        User user = new User();
        user.setId(0);
        user.setUserName("kaustav pal");
        user.setEmailId("kaustavlogan@gmail.com");
        user.setPassword("1234567890");
        user.setGenres(null);
        user.setGender("male");
        producer.send(user);

    }
}
