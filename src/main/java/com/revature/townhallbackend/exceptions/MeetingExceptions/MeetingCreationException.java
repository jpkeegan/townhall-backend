package com.revature.townhallbackend.exceptions.MeetingExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CREATED, reason = "Meeting created successfully.")
public class MeetingCreationException extends Exception{
    public MeetingCreationException(){
        super("Meeting Successfully Created");
    }
}
