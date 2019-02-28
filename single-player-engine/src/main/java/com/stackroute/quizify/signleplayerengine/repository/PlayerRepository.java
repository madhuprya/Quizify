package com.stackroute.quizify.signleplayerengine.repository;

import com.stackroute.quizify.signleplayerengine.domain.SinglePlayer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<SinglePlayer, Long> {

    Optional<SinglePlayer> findTopByOrderByIdDesc();


}
