package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "TopicServiceImpl" Class implements all the methods declared by "TopicService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */

@Service
public class TopicServiceImpl implements TopicService{

    private TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }

//    @Override
//    public List<Topic> getAllTopicByName(String topicName) throws TopicDoesNotExistsException {
//        List<Topic> allTopics = topicRepository.searchByTopicName(topicName);
//        if(allTopics==null)
//            throw new TopicDoesNotExistsException("No Game Found");
//        else
//            return allTopics;
//    }

    @Override
    public Topics saveTopic(Topics topic) throws TopicAlreadyExistsException {
        if (this.topicRepository.existsById(topic.getId()))
            throw new TopicAlreadyExistsException("Genre Already Exists!");
        else
        {
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topic.setId(1);
            else
                topic.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            return topicRepository.save(topic);
        }
    }

    @Override
    public List<Topics> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException {
        List<Topics> topics = topicRepository.searchByTopicAlphabet(topicName);
        if(topics==null)
            throw new TopicDoesNotExistsException("No Game Found");
        else
            return topics;
    }
}
