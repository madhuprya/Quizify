package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Played;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PlayedRelationshipRepository extends Neo4jRepository<Played,String> {

    @Query("MATCH p=(Users)-[r:Played]->(Games) RETURN p")
    public List<Played> getAllRelationships();

    @Query("MATCH (p:Users),(t:Games) WHERE id(p)={userId} and id(t)={gameId} CREATE (p)-[q:Played]->(t) RETURN p,q,t")
    Played createRelationship(@Param("userId") long userId, @Param("gameId") long gameId);

    @Query("MATCH (p:Users)-[r:Played]->(t:Games) WHERE userId(p)={userId} and gameId(t)={gameId} DELETE r RETURN 'relationship deleted' ")
    Played deleteRelationship(@Param("userId") Long userId, @Param("gameId") long gameId);

}
