package com.stackroute.quizify.questionmanager.controller;

import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
import com.stackroute.quizify.questionmanager.service.QuestionService;
import com.stackroute.quizify.kafka.domain.Question;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Question Manager Service")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ApiOperation(value = "Add Question")
    @PostMapping("/questions/question")
    public ResponseEntity<?> saveQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<Question>(this.questionService.addNewQuestion(question), HttpStatus.OK);
        } catch (QuestionAlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Update Question")
    @PutMapping("/questions/question")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<Question>(this.questionService.updateQuestion(question), HttpStatus.OK);
        } catch (QuestionDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Remove Question")
    @DeleteMapping("/questions/question")
    public ResponseEntity<?> removeQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<Question>(this.questionService.removeQuestion(question), HttpStatus.OK);
        } catch (QuestionDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Questions By Tag By Level")
    @GetMapping("/questions/tag/{tag}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTagByLevel(@PathVariable String tag, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTagByLevel(tag, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Tag")
    @GetMapping("/questions/tag/{tag}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTag(@PathVariable String tag, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTag(tag, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Tag")
    @GetMapping("/questions/tag/{tag}")
    public ResponseEntity<?> getAllQuestionsByTag(@PathVariable String tag) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByTag(tag), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Questions By Topic By Level")
    @GetMapping("/questions/topic/{topicName}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTopicByLevel(@PathVariable String topicName, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTopicByLevel(topicName, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Topic")
    @GetMapping("/questions/topic/{topicName}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTopic(@PathVariable String topicName, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTopic(topicName, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Topic")
    @GetMapping("/questions/topic/{topicName}")
    public ResponseEntity<?> getAllQuestionsByTopic(@PathVariable String topicName) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByTopic(topicName), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Genre By Level")
    @GetMapping("/questions/genre/{genre}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByGenreByLevel(@PathVariable String genre, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByGenreByLevel(genre, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Genre")
    @GetMapping("/questions/genre/{genre}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByGenre(@PathVariable String genre, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByGenre(genre, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Genre")
    @GetMapping("/questions/genre/{genre}")
    public ResponseEntity<?> getAllQuestionsByGenre(@PathVariable String genre) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByGenre(genre), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
