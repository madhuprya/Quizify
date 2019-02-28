package com.stackroute.quizify.recommendationservice.domain;


import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Transient;



@NodeEntity
@Data
public class Users {
    @Id @GeneratedValue
    private long userId;
    @Property
    private String userName;
    private String password;
    private String confirmpassword;
    private String emailId;

    private String[] Interests;
    @Property
    private String gender;
}


//    CREATE (Peter:Users{userName: 'Peter N', gender: 'male'}) CREATE (Sam:Users {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:Users {userName: 'Ryan A', gender: 'male'})

