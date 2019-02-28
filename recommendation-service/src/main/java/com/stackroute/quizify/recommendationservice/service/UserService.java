package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<Users> getAll();

    public Users getone(long userId);

    public Users create(Users users);

    public Users delete(long userId);

    public Users update(Users users);
}
