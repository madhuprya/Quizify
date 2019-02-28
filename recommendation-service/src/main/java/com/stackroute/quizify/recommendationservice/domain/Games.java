package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
public class Games {
    @Id @GeneratedValue
    private long gameId;
    @Property
    private String gameName;
    @Property
    private int gamesPlayed;
    @Property
    private String level;
    @Property
    private String imageUrl;
    @Property
    private String description;
    @Property
    private long duration;
    @Property
    private int likes;
    @Property
    private int numOfQuestion;
}
