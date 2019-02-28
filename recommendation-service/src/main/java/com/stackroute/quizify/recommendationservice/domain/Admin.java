package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Admin {
    @Id
    private long id;
    private String name;
}
