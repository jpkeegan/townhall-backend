package com.revature.townhallbackend.exceptions.UserExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CREATED, reason = "User Created Successfully")
public class UserCreationException extends Exception{
    public UserCreationException(){
        super("User Successfully Created");
    }
}
