package com.stackroute.quizify.userauthentication.domain;

import javax.persistence.Id;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//@Data
public class LoginUser {
    @Id
    private String username;
    private String password;
    private String role;

}
