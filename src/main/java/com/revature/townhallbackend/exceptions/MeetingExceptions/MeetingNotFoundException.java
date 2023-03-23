package com.revature.townhallbackend.exceptions.MeetingExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "No Meeting Found with that ID")
public class MeetingNotFoundException extends Exception{
    public MeetingNotFoundException(){
        super("No Meeting Found with that ID");
    }
}
