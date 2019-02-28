package com.stackroute.quizify.userregistrationservice.service;

import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;
import com.stackroute.quizify.userregistrationservice.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    private Producer producer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Producer producer) {
        this.userRepository = userRepository;
        this.producer = producer;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistException("user already exists");
        }
        else
        {
            if(this.userRepository.findTopByOrderByIdDesc().isEmpty())
                user.setId(1);
            else
                user.setId(this.userRepository.findTopByOrderByIdDesc().get().getId()+1);
            return producer.send(this.userRepository.save(user));
        }
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        if (userRepository.existsById(user.getId())) {
            return producer.send(userRepository.save(user));
        } else
            throw new UserNotFoundException("user not found");
    }


    @Override
    public User deleteUser(long id) throws UserNotFoundException {

        if(this.userRepository.existsById(id)) {
            User user = this.userRepository.findById(id).get();
            this.userRepository.delete(user);
            return user;
        }
        else
            throw new UserNotFoundException("user not found");

    }
}