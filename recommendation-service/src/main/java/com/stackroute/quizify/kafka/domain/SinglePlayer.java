package com.stackroute.quizify.kafka.domain;

import lombok.Data;

@Data
public class SinglePlayer {
    private Game game;
    private User user;
}
