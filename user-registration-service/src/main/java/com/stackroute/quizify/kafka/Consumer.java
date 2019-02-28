package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
public class Consumer {


    //private Game recievedPayload;



    //public Game getRecievedPayload()
   // {
     //   return this.recievedPayload;
    //}

    @KafkaListener(topics = "users", groupId = "users-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload User payload) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("User Received At User Registration Service : ");
        System.out.println(payload);


      //  this.recievedPayload = payload;


    }

}
