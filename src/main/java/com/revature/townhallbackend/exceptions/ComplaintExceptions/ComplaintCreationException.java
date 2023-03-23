package com.revature.townhallbackend.exceptions.ComplaintExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CREATED, reason = "Complaint Created Successefully")
public class ComplaintCreationException extends Exception{
    public ComplaintCreationException(){
        super("Complaint Successfully Created");
    }
}
