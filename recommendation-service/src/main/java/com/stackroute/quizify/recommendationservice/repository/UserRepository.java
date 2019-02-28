package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Users;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends Neo4jRepository<Users, Long> {
    
    @Query("MATCH (Users) RETURN Users")
    public List<Users> getAllNodes();

    @Query("MATCH (u:Users) WHERE id(u)={userId} RETURN u")
    public Users getNode(@Param("userId") long userId);

    @Query("CREATE (u:Users) SET u.id={userId},u.userName={userName},u.gender={gender} RETURN u")
    Users createNode(long userId, String userName, String gender);

    @Query("MATCH (n:Users) WHERE id(n)={userId} DETACH DELETE n RETURN 'node deleted' ")
    Users deleteNode(@Param("userId") long userId);

    @Query("MATCH (n:Users) WHERE id(n)={userId} SET n.userName={userName},n.gender={gender} RETURN n")
    Users updateNode(@Param("userId") long userId, @Param("userName") String userName, @Param("gender") String gender);
}
