package com.stackroute.quizify.signleplayerengine.domain;



import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class Question {
@Id
    private String id;
    private Category category;
    private Topic topic;
    private String level;
    private String genre;
    private String type;
    private String statement;
    private List<String> options;
    private long timeStamp;
    private String answer;
    private String playeranswer;
    private Admin admin;
}
