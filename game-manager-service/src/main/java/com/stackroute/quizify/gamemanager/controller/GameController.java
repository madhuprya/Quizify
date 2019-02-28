package com.stackroute.quizify.gamemanager.controller;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.gamemanager.exception.GameNotFound;
import com.stackroute.quizify.gamemanager.service.GameService;
import com.stackroute.quizify.kafka.domain.Game;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Api(description = "Game Manager Services")
public class GameController {

    private GameService gameService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GameController(GameService gameService)
    {
        this.gameService=gameService;
    }

    @ApiOperation(value = "Add Games")
    @PostMapping("/games/game")
    public ResponseEntity<?> saveGame(@RequestBody Game game){
        try {
            return new ResponseEntity<Game>(this.gameService.saveGame(game), HttpStatus.OK);
        } catch (GameAlreadyExists e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @ApiOperation(value = "Delete Game")
    @DeleteMapping("/games/game")
    public ResponseEntity<?> deleteGame(@RequestBody Game game)
    {
        try {
            return new ResponseEntity<Game>(this.gameService.deleteGame(game), HttpStatus.OK);
        } catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @ApiOperation(value = "Updating Game")
    @PutMapping("/games/game")
    public ResponseEntity<?> updateGame(@RequestBody Game updatedGame){
        try {
            return new ResponseEntity<Game>(this.gameService.updateGame(updatedGame), HttpStatus.OK);
        } catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @ApiOperation(value = "Generate Live Game")
    @GetMapping(value = "/games/game/{id}")
    public ResponseEntity<?> generateLiveGameByTopic(@PathVariable long id){
        try {
            Game liveGame = this.gameService.findGameById(id);
            String topicName = liveGame.getTopic().getName();
            String tag = liveGame.getTag();
            String level = liveGame.getLevel();
            int numberOfQuestions = liveGame.getNumOfQuestion();
            String url = "http://0.0.0.0:8092/question-manager-service/api/v1/questions/";

            if (tag.isEmpty())
            {
                url += "topic/"+topicName+"/"+level+"/"+numberOfQuestions;

            }
            else
            {
                url += "tag/"+tag+"/"+level+"/"+numberOfQuestions;

            }

            liveGame.setQuestions(restTemplate.getForObject(url, ArrayList.class));
//            System.out.println("Live Game : ");
//            System.out.println(liveGame);
            return new ResponseEntity<Game>(liveGame, HttpStatus.OK);

        } catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//    @ApiOperation(value = "Get All Questions")
//    @GetMapping("/games/{genre}/{topic}")
//    public ResponseEntity<?> getAllGames(@PathVariable String genre, @PathVariable String topic) throws GameNotFound {
//        try {
//            return new ResponseEntity<List<Game>>(this.gameService.getAllGames(genre, topic), HttpStatus.OK);
//        } catch (GameNotFound e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
}
