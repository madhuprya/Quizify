package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;
import com.stackroute.quizify.kafka.domain.Game;


public interface GameService {

   Game saveGame(Game game) throws GameAlreadyExists;

   Game deleteGame(Game game) throws GameNotFound;

   Game updateGame(Game game) throws GameNotFound;

   Game findGameById(long id) throws GameNotFound;


//   List<Game> getAllGames(String genre, String topicName) throws GameNotFound;

}
