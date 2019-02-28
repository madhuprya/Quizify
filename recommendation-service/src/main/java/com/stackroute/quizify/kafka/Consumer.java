//package com.stackroute.quizify.kafka;
//
//import com.stackroute.quizify.kafka.domain.Game;
//import com.stackroute.quizify.kafka.domain.SinglePlayer;
//import com.stackroute.quizify.kafka.domain.User;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class Consumer {
//
//    //private Game recievedPayload;
//
//
//
//    //public Game getRecievedPayload()
//   // {
//     //   return this.recievedPayload;
//    //}
//
//    @KafkaListener(topics = "games", groupId = "recommendation-game-consumer", containerFactory = "kafkaListenerGameContainerFactory")
//    public void receiveGame(@Payload Game payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Game Received To Recommendation : ");
//        System.out.println(payload);
//
//    }
//
//    @KafkaListener(topics = "users", groupId = "recommendation-users-consumer", containerFactory = "kafkaListenerUserContainerFactory")
//    public void receiveUser(@Payload User payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Users Received To Recommendation : ");
//        System.out.println(payload);
//
//    }
//
//    @KafkaListener(topics = "singlePlayers", groupId = "recommendation-single-player-consumer", containerFactory = "kafkaListenerSinglePlayerContainerFactory")
//    public void receiveSinglePlayer(@Payload SinglePlayer payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("SinglePlayer Received To Recommendation : ");
//        System.out.println(payload);
//
//    }
//
//}
//
