package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;

@Data
@NodeEntity
public class Genre {
    @Id
    @GeneratedValue
    private Long genreId;
    @Property
    private String genreName;
    @Property
    private String imageUrl;
}