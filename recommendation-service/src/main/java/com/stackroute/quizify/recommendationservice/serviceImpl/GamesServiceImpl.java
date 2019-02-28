package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.repository.GamesRepository;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    GamesRepository gamesRepository;

    @Autowired
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Games> getAll() {
        return gamesRepository.getAllNodes();
    }

    @Override
    public Games getone(long gamesId) {
        return gamesRepository.getNode(gamesId);
    }

    @Override
    public Games create(Games games) {
        long id=games.getGameId();
        String name=games.getGameName();
        return gamesRepository.createNode(id,name);
    }

    @Override
    public Games delete(long gamesId) {
        return gamesRepository.deleteNode(gamesId);
    }

    @Override
    public Games update(Games games) {
        long id=games.getGameId();
        String name=games.getGameName();
        return gamesRepository.updateNode(id,name);
    }
}
