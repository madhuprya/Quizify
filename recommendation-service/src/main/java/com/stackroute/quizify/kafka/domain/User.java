package com.stackroute.quizify.kafka.domain;


import com.stackroute.quizify.recommendationservice.domain.Genre;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
public class User {

    @Id
    private long userId;

    private String userName;
    private String password;
    private String emailId;

    private Topic topic;
    private List<Genre> genres;


    private String gender;;
}


//    CREATE (Peter:Users{userName: 'Peter N', gender: 'male'}) CREATE (Sam:Users {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:Users {userName: 'Ryan A', gender: 'male'})

