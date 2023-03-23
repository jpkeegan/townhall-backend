package com.revature.townhallbackend.exceptions.UserExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidUserCredentialsException extends Exception {
    public InvalidUserCredentialsException(){
        super("Invalid User Credentials");
    }
}
