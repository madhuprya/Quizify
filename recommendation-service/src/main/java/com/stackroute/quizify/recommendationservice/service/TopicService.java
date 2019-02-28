package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Topics;

import java.util.List;


public interface TopicService {

    public List<Topics> getAll(long categoryId);
}
