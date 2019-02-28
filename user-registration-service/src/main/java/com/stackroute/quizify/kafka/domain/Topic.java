package com.stackroute.quizify.kafka.domain;

import lombok.Data;

import java.util.List;


@Data
public class Topic {
    private long id;
    private String topciName;
    private String imageUrl;
}
