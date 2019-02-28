package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;
import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.gamemanager.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl implements GameService {

    private static Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private GameRepository gameRepository;
    private Producer producer;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, Producer producer){

        this.gameRepository=gameRepository;
        this.producer = producer;
     }

     @Override
     public Game saveGame(Game game) throws GameAlreadyExists {
         if(this.gameRepository.existsById(game.getId()))
             throw new GameAlreadyExists("Game already exists");
         else {
             if(this.gameRepository.findTopByOrderByIdDesc().isEmpty())
                 game.setId(1);
             else
                 game.setId(this.gameRepository.findTopByOrderByIdDesc().get().getId()+1);
             return producer.send(this.gameRepository.save(game));
//            return this.questionRepository.save(question);
         }


     }

    @Override
    public Game deleteGame(Game game) throws GameNotFound {
        if(this.gameRepository.existsById(game.getId())) {
             this.gameRepository.delete(game);
             return game;
        }
        else
            throw  new GameNotFound("Game Not exist");
    }



    @Override
    public Game updateGame(Game updatedGame) throws GameNotFound{

    if(this.gameRepository.existsById(updatedGame.getId()))
        return producer.send(this.gameRepository.save(updatedGame));
    else
        throw new GameNotFound("Game not found");

    }

    @Override
    public Game findGameById(long id) throws GameNotFound {
        if (this.gameRepository.existsById(id))
            return this.gameRepository.findById(id).get();
        else
            throw new GameNotFound("Game Not Found!");
    }

//    @Override
//    public List<Game> getAllGames(String genre, String topicName) throws GameNotFound{
//
//        List<Game> gameList = this.gameRepository.getAllGames(genre, topicName);
//        if(gameList.isEmpty())
//            throw  new GameNotFound("no game found");
//        else {
//             return gameList;
//        }
//
//    }



}
