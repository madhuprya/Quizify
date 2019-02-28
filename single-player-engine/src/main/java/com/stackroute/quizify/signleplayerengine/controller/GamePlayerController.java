package com.stackroute.quizify.signleplayerengine.controller;

import com.stackroute.quizify.signleplayerengine.domain.Game;
import com.stackroute.quizify.signleplayerengine.domain.SinglePlayer;
import com.stackroute.quizify.signleplayerengine.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Single Player Service")
public class GamePlayerController {

    private PlayerService playerService;
    private ResponseEntity<?> responseEntity;
    RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public GamePlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @ApiOperation(value = "Get User Game")
    @GetMapping(value = "/{gameId}")
    public ResponseEntity<?> getGame( @PathVariable String gameId)
    {
            SinglePlayer singlePlayer = new SinglePlayer();
            String url = "http://13.232.243.68:8102/api/v1/games/game/" +
                   singlePlayer.getGame().getName();

            Game game = restTemplate.getForObject(url, Game.class);
            singlePlayer.setGame(game);
            return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);
    }


}
