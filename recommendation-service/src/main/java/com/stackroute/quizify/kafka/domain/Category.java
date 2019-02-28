package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category{

    @Id
    private long id;
    private String categoryName;
    private String imageUrl;
}