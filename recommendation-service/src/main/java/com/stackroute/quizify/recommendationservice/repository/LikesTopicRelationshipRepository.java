/*
package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesTopicRelationshipRepository extends Neo4jRepository<LikesTopic,String> {

    @Query("MATCH p=(Users)-[r:LikesTopic]->(Topics) RETURN p")
    public List<LikesTopic> getAllRelationships();

    @Query("MATCH (p:Users),(t:Topics) WHERE id(p)={userId} and id(t)={topicId} CREATE (p)-[q:LikesTopic}]->(t) RETURN p,q,t")
    LikesTopic createRelationship(@Param("userId") long userId, @Param("topicId") long topicId);

    @Query("MATCH (p:Users)-[r:LikesTopic]->(t:Topics) WHERE id(p)={userId} and id(t)={topicId} DELETE r RETURN 'relationship deleted' ")
    LikesTopic deleteRelationship(@Param("userId") Long userId, @Param("topicId") long topicId);
}
*/
