package com.stackroute.quizify.kafka.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
public class User {
    @Id
    private long userId;
    private String userName;
    private String password;
    private String emailId;
    private List<String> interests;
    private String gender;
}
