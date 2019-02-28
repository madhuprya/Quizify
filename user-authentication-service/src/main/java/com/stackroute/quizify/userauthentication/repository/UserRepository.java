package com.stackroute.quizify.userauthentication.repository;

import com.stackroute.quizify.userauthentication.domain.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LoginUser,String>
{

     LoginUser findByUsernameAndPassword(String username,String password);
}
