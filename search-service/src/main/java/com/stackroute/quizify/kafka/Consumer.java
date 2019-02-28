package com.stackroute.quizify.kafka;

import com.stackroute.quizify.kafka.domain.Game;

import com.stackroute.quizify.searchservice.domain.Games;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Consumer {

    private Games recievedGame;
    private GenreRepository genreRepository;
    private TopicRepository topicRepository;

    public Consumer(GenreRepository genreRepository, TopicRepository topicRepository) {
        this.genreRepository = genreRepository;
        this.topicRepository = topicRepository;
    }

    //private Game recievedPayload;



    //public Game getRecievedPayload()
   // {
     //   return this.recievedPayload;
    //}

    @KafkaListener(topics = "games", groupId = "search-games-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload Game payload) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Game Received To Search : ");
        System.out.println(payload);


      //  this.recievedPayload = payload;

        recievedGame = new Games();
        recievedGame.setGameId(payload.getId());
        recievedGame.setGameName(payload.getName());
        recievedGame.setLevel(payload.getLevel());
        recievedGame.setImageUrl(payload.getImageUrl());
        recievedGame.setNumOfQuestion(payload.getNumOfQuestion());
        recievedGame.setDuration(payload.getTimeDuration());
        recievedGame.setDescription(payload.getRules());
        recievedGame.setGamesPlayed(payload.getPlayCount());
        recievedGame.setLikes(payload.getLiked());

        List<Games> newList = null;
        Topics topic =null;
        Genres genre = null;

        if (this.topicRepository.existsByName(payload.getTopic().getName()))
        {
            topic = this.topicRepository.findByName(payload.getTopic().getName());
            newList = topic.getGame();
            newList.add(recievedGame);
            topic.setGame(newList);
            this.topicRepository.save(topic);
        }
        else
        {
            topic = new Topics();
            newList = new ArrayList<>();
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topic.setId(1);
            else
                topic.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            topic.setName(payload.getTopic().getName());
            newList.add(recievedGame);
            topic.setGame(newList);
            this.topicRepository.save(topic);
        }

        if (this.genreRepository.existsByName(payload.getGenre()))
        {
            genre = this.genreRepository.findByName(payload.getGenre());
            newList = genre.getGame();
            newList.add(recievedGame);
            genre.setGame(newList);
            this.genreRepository.save(genre);
        }
        else
        {
            genre = new Genres();
            newList = new ArrayList<>();
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genre.setId(1);
            else
                genre.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            genre.setName(payload.getGenre());
            newList.add(recievedGame);
            genre.setGame(newList);
            this.genreRepository.save(genre);
        }


    }

}
