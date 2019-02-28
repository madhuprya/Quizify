package com.stackroute.quizify.kafka.domain;

import lombok.Data;


@Data
public class Genre {

    private Long genreId;
    private String genreName;
    private String imageUrl;
}
