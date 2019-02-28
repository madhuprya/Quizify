package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.LoginUser;
import com.stackroute.quizify.userauthentication.exceptions.UserNameNotFoundException;

import java.util.List;

public interface UserService
{
    public LoginUser saveUser(LoginUser user) throws UserNameNotFoundException; //users ADDED

    public List<LoginUser> getAllUsers();  ///RETRIEVE users

    public LoginUser findByUserIdAndPassword(String username,String password);
}
