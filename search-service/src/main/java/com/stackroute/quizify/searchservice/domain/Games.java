package com.stackroute.quizify.searchservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.List;

/*
 * This "Game" class is used to get game names from our message bus(Kafka).
 *
 * The Annotation "@Data" is used as a convenient shortcut annotation that bundles the features
 * of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple
 * POJOs (Plain Old Java Objects).
 *
 * The Annotation "@Id" is used to declare that the field "id" as the Primary Key which will be
 * Non-Null and Unique.
 */

@Data
public class Games {
    @Id
    private long gameId;
    private String gameName;
    private int gamesPlayed;
    private String level;
    private String imageUrl;
    private String description;
    private long duration;
    private int likes;
    private int numOfQuestion;

}
