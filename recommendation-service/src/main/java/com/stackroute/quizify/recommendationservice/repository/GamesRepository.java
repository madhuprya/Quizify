package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Games;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends Neo4jRepository<Games,Long> {
    @Query("MATCH (Games) RETURN Games")
    public List<Games> getAllNodes();

    @Query("MATCH (g:Games) WHERE gameId(g)={gameId} RETURN g")
    public Games getNode(@Param("gameId") long gameId);

    @Query("CREATE (g:Games) SET g.gameId={gameId},g.gameName={gameName} RETURN g")
    Games createNode( long gameId,String gameName);

    @Query("MATCH (g:Games) WHERE gameId(g)={gameId} DETACH DELETE g RETURN 'node deleted' ")
    Games deleteNode(@Param("gameId") long gameId);

    @Query("MATCH (g:Games) WHERE gameId(g)={gameId} SET g.gameName={gameName} RETURN g")
    Games updateNode(@Param("gameId") long gameId,@Param("gameName") String gameName);

}
