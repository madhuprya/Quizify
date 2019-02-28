package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category {
        @Id
    private String name;
    private String imageUrl;
    private long timeStamp;
    private Admin admin;

}
