package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.LoginUser;
import com.stackroute.quizify.userauthentication.exceptions.UserNameNotFoundException;
import com.stackroute.quizify.userauthentication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.userRepo = repo;
    }


    @Override
    public LoginUser findByUserIdAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }


    @Override
    public LoginUser saveUser(LoginUser user)throws UserNameNotFoundException
    {
        if(userRepo.existsById(user.getUsername())){
            throw new UserNameNotFoundException("LoginUser already exists!!");

        }
        LoginUser userSaved = userRepo.save(user);
        return userSaved;

    }


    @Override
    public List<LoginUser> getAllUsers() {
        return userRepo.findAll();
    }



}
