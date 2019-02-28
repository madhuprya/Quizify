package com.stackroute.quizify.userauthentication.jwt;

import com.stackroute.quizify.userauthentication.domain.LoginUser;

import java.util.Map;
@FunctionalInterface
public interface SecurityTokenGenrator
{


    Map<String, String> generateToken(LoginUser user);
}
