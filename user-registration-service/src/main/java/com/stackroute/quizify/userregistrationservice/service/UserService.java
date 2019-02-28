package com.stackroute.quizify.userregistrationservice.service;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

     User saveUser(User user) throws UserAlreadyExistException;
     List<User> getAllUsers()throws UserNotFoundException;
     User updateUser(User user) throws UserNotFoundException;
     User deleteUser(long id) throws UserNotFoundException;

}
