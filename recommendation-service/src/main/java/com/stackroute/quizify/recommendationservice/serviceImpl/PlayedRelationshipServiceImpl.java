package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;
import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.repository.PlayedRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.PlayedRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayedRelationshipServiceImpl implements PlayedRelationshipService {

    PlayedRelationshipRepository playedRelationshipRepository;


    @Autowired
    public PlayedRelationshipServiceImpl(PlayedRelationshipRepository playedRelationshipRepository) {
        this.playedRelationshipRepository = playedRelationshipRepository;
    }

    @Override
    public List<Played> getAllRelationships() {
        return playedRelationshipRepository.getAllRelationships();
    }

    @Override
    public Played createRelationship(SinglePlayer singlePlayer) {
        Users user=singlePlayer.getUser();
        System.out.println(" user name" + user.getUserName());
        long userId=user.getUserId();
        System.out.println(userId);
        Games game=singlePlayer.getGame();
        long gameId=game.getGameId();
        return playedRelationshipRepository.createRelationship(userId,gameId);
    }

}
