package com.revature.townhallbackend.exceptions.ComplaintExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "No Complaint Found With This Id")
public class ComplaintNotFoundException extends Exception{
    public ComplaintNotFoundException(){
        super("No Complaint Found With this ID");
    }
}
