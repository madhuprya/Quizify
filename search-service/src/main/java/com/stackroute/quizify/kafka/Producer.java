//package com.stackroute.quizify.kafka;
//
//import Game;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Producer {
//
//    @Value("${kafka.topic}")
//    private  String topic;
//
//    private Game payload;
//
//    private Logger logger = LoggerFactory.getLogger(Producer.class);
//
//
//    private KafkaTemplate<String, Game> kafkaTemplate;
//
//    public Game getPayload()
//    {
//        return this.payload;
//    }
//
//    @Autowired
//    public Producer(KafkaTemplate<String, Game> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public Game send(Game payload) {
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("Game Sent");
//        System.out.println(payload);
//        kafkaTemplate.send(topic, payload);
//        this.payload = payload;
//        return payload;
//    }
//}
