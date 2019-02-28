package com.stackroute.quizify.userregistrationservice.controller;

import com.stackroute.quizify.kafka.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;


import com.stackroute.quizify.userregistrationservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (value = "*")
@RestController
@RequestMapping(value = "/api/v1")
@Api(description = "shows the user information")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Accepts user into the repository")
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException {

        try{
            return new ResponseEntity<User>(this.userService.saveUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyExistException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Accepts users into the repository")

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser() {
        try {
            return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
        } catch (UserNotFoundException e) {
           return new ResponseEntity<String>( e.getMessage(), HttpStatus.CREATED);
        }
    }

    @ApiOperation(value = "Updates user into the repository")
    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) throws UserNotFoundException, UserAlreadyExistException {
        ResponseEntity responseEntity;


        responseEntity=new ResponseEntity<User>( this.userService.updateUser(user), HttpStatus.CREATED);

        return responseEntity;

    }
    @ApiOperation(value = "Removes the user into the repository")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getDeleteUser(@PathVariable Long id) throws UserNotFoundException{
        ResponseEntity responseEntity;

        responseEntity = new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.CREATED);

         return responseEntity;

    }
}

