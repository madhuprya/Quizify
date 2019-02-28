package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SinglePlayer {
    @Id
    private long id;
    private Game game;
    private User users;
}
