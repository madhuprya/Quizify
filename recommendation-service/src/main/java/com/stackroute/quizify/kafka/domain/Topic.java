package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;


@Data
public class Topic {

    @Id
    private long id;
    private String topciName;
    private String imageUrl;
}
