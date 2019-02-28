package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/*
 * This "Admin" class is used to create documents which will store admin details.
 *
 * The Annotation "@Data" is used as a convenient shortcut annotation that bundles the features
 * of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple
 * POJOs (Plain Old Java Objects).
 *
 * The Annotation "@Id" is used to declare that the field "id" as the Primary Key which will be
 * Non-Null and Unique.
 *
 * The Field "id" will contain the Unique ID of Admin
 *
 * The Field "name" will contain user name or full name of the Admin.
 */

@Data
public class Admin {
    @Id
    private long id;
    private String name;
}
