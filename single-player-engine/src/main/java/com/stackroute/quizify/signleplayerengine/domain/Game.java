package com.stackroute.quizify.signleplayerengine.domain;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Game {
    @Id
    public String gameId;
    private String name;
    private Category category;
    private Topic topic;
    private int playCount;
    private int numOfQuestion;
    private List<Question> questions;
    private Admin admin;
    private String level;
    private String genre;
    private String tag;
    private int liked;
    private int played;
    private int timestamp;

}
