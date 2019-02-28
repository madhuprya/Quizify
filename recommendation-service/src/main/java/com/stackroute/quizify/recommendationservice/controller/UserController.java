package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Users;
import com.stackroute.quizify.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Users> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id")
    public Users getOne(@RequestParam("userId") long userId){
        return userService.getone(userId);
    }

    @PostMapping("/")
    public Users create(@RequestBody Users users){
        return userService.create(users);
    }

    @DeleteMapping("/")
    public Users delete(@RequestParam("userId") long userId){
        System.out.println(userId);
        return userService.delete(userId);
    }

    @PutMapping("/")
    public Users update(@RequestBody Users users)
    {
        return userService.update(users);
    }

}
