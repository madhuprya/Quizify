package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Value("${kafka.topic}")
    private  String topic;

    private User payload;

    private Logger logger = LoggerFactory.getLogger(Producer.class);


    private KafkaTemplate<String, User> kafkaTemplate;

    public User getPayload()
    {
        return this.payload;
    }

    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public User send(User payload) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("User Sent");
        System.out.println(payload);
        kafkaTemplate.send(topic, payload);
        this.payload = payload;
        return payload;
    }
}
