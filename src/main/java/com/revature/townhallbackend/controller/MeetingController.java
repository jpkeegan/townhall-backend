package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingCreationException;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingNotFoundException;
import com.revature.townhallbackend.service.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    Logger logger = LoggerFactory.getLogger(MeetingController.class);

    @GetMapping("/meetings")
    public List<Meeting> getAllMeetings() {
        logger.info("Getting All Meetings");
        return meetingService.getAllMeetings();
    }

    @GetMapping("/meeting/{meeting_id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable("meeting_id") Long meeting_id) throws MeetingNotFoundException {
        logger.info("Getting meeting by Id: " + meeting_id);
        Meeting meeting = meetingService.getMeetingById(meeting_id);
        return ResponseEntity.ok(meeting);
    }

    @PostMapping("/meetings")
    public ResponseEntity<Meeting> insertMeeting(@RequestBody Meeting meeting) throws MeetingCreationException {
        logger.info("Adding Meeting: " + meeting.toString());
        Meeting createdMeeting = meetingService.insertMeeting(meeting);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMeeting);
    }

    @PutMapping("meeting/{meeting_id}")
    public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) throws MeetingNotFoundException {
        logger.info("Updating meeting: " + meeting.toString());
        Meeting updatedMeeting = meetingService.updateMeeting(meeting);
        return ResponseEntity.ok(updatedMeeting);
    }

    @DeleteMapping("meeting/{meeting_id}")
    public boolean deleteMeeting(@PathVariable("meeting_id") Long meeting_id){
        logger.info("Deleting meeting with Id: " + meeting_id);
        return meetingService.deleteMeeting(meeting_id);
    }
}
