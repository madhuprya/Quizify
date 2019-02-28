package com.stackroute.quizify.kafka.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection="games")
public class Game {

    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private String tag;
    private String genre;
    private String level;
    private String imageUrl;
    private int numOfQuestion;
    private List<Question> questions;
    private int liked;
    private int playCount;
    private String rules;
    private long timeDuration;
    private Admin admin;

}
