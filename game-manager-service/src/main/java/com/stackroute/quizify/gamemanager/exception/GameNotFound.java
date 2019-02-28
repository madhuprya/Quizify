package com.stackroute.quizify.gamemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Specified Game Not Found on server")
public class GameNotFound  extends Exception{
    String message;
        public GameNotFound(String message) {
            super(message);
            this.message=message;
        }
}
