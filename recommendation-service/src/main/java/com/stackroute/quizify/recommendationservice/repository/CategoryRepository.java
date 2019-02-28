package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Categories;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Categories,Long> {

    @Query("MATCH (Categories) RETURN Categories")
    public List<Categories> getAllNodes();
}
