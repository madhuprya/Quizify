package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.repository.UserRepository;
import com.stackroute.quizify.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAll() {
        return userRepository.getAllNodes();
    }

    @Override
    public Users getone(long userId) {
        return userRepository.getNode(userId);
    }

    @Override
    public Users create(Users users) {
        long id= users.getUserId();
        String name= users.getUserName();
        String gender= users.getGender();
        return userRepository.createNode(id,name,gender);
    }
    @Override
    public Users delete(long userId) {
        return userRepository.deleteNode(userId);
    }

    @Override
    public Users update(Users users) {
        long id= users.getUserId();
        String name= users.getUserName();
        String gender= users.getGender();
        return userRepository.updateNode(id,name,gender);
    }
}
