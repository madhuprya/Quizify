package com.stackroute.quizify.kafka.domain;

import com.stackroute.quizify.signleplayerengine.domain.Game;
import com.stackroute.quizify.signleplayerengine.domain.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class SinglePlayer {
    @Id
    private long id;
    private Game game;
    private User users;
}
