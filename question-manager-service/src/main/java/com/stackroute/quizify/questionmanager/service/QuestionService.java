package com.stackroute.quizify.questionmanager.service;

import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
import com.stackroute.quizify.kafka.domain.Question;

import java.util.List;

/*
 * This "QuestionService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (QuestionServiceImpl).
 *
 *The Method "addNewQuestion" will add/save a new document of Question in a collection,
 * and will return the Saved/Added Question.
 * If Question ID already exist then it will throw the Exception "CategoryNameAlreadyExistsException".
 *
 *The Method "updateQuestion" will update the Question Document, and will return the Updated Document.
 * If any Question not found with the question ID then it will throw the exception "QuestionDoesNotExistException".
 *
 * The Method "removeQuestion" will delete/remove a specific Question form the collection and will
 * return the Deleted/Removed Question.
 * If the Question doesn't exist then it will throw "QuestionDoesNotExistException".
 *
 * The Method "getQuestion" will fetch specific number of Questions matching a given categoryName, a given topicName
 * and a given level.
 * If no Question found then it will throw the exception "NoQuestionFoundException".
 *
 * The Method "getAllQuestions" will fetch all of the Questions matching a given categoryName and a given topicName.
 * If no Question found then it will throw the exception "NoQuestionFoundException".
 */

public interface QuestionService {
    Question addNewQuestion(Question question) throws QuestionAlreadyExistsException;
    Question updateQuestion(Question question) throws QuestionDoesNotExistException;
    Question removeQuestion(Question question) throws QuestionDoesNotExistException;

    List<Question> getQuestionsByTagByLevel(String tag, String level, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getQuestionsByTag(String tag, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getAllQuestionsByTag(String tag)throws NoQuestionFoundException;

    List<Question> getQuestionsByTopicByLevel(String topicName, String level, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getQuestionsByTopic(String topicName, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getAllQuestionsByTopic(String topicName)throws NoQuestionFoundException;

    List<Question> getQuestionsByGenreByLevel(String genre, String level, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getQuestionsByGenre(String genre, int numberOfQuestions)throws NoQuestionFoundException;
    List<Question> getAllQuestionsByGenre(String genre)throws NoQuestionFoundException;


//    List<Question> getQuestionsByCategoryByLevel(String categoryName, String level)throws NoQuestionFoundException;
//    List<Question> getQuestionsByCategory(String categoryName)throws NoQuestionFoundException;
}
