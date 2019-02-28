package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Question;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private Question recievedPayload;

    public Question getRecievedPayload()
    {
        return this.recievedPayload;
    }

    @KafkaListener(topics = "questions", groupId = "questions-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload Question payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Recieved : ");
//        System.out.println(payload);

        this.recievedPayload = payload;
    }

}
