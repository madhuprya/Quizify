package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
public class Topic {
    @Id
    private String name;
    private String imageUrl;
    private long timeStamp;
    private List<Topic> subTopics;
    private Admin admin;
}
