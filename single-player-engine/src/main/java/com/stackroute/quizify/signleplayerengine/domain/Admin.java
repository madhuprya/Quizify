package com.stackroute.quizify.signleplayerengine.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Admin {
@Id
    private String id;
    private String name;

}
