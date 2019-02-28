package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Topics;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TopicRepository extends Neo4jRepository<Topics,Long> {


    @Query("MATCH p=(t:Topics)-[r:is_type_of]->(c:Categories) WHERE id(c)={categoryId}  RETURN t")
    public List<Topics> getAllNodes(long categoryId);
}
