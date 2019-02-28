package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Games;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/games")
public class GamesController {

    private GamesService gamessService;

    @Autowired
    public GamesController(GamesService gamessService) {
        this.gamessService = gamessService;
    }

    @GetMapping("/")
    public List<Games> getAll(){
        return gamessService.getAll();
    }

    @GetMapping("/id")
    public Games getOne(@RequestParam("GamesId") long GamesId){
        return gamessService.getone(GamesId);
    }

    @PostMapping("/")
    public Games create(@RequestBody Games Games){
        return gamessService.create(Games);
    }

    @DeleteMapping("/")
    public Games delete(@RequestParam("GamesId") long GamesId){
        System.out.println(GamesId);
        return gamessService.delete(GamesId);
    }

    @PutMapping("/")
    public Games update(@RequestBody Games Games)
    {
        return gamessService.update(Games);
    }

}
