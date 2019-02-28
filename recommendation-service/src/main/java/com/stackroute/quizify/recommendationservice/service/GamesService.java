package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Games;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GamesService {

    public List<Games> getAll();

    public Games getone(long gameId);

    public Games create(Games games);

    public Games delete(long gamed);

    public Games update(Games games);
}
