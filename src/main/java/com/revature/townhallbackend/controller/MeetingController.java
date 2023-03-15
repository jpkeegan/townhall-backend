package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/meetings")
    public List<Meeting> getAllMeetings() {return meetingService.getAllMeetings();}

    @GetMapping("/meeting/{meeting_id}")
    public Meeting getMeetingById(@PathVariable("meeting_id") Long meeting_id){
        return meetingService.getMeetingById(meeting_id);
    }

    @PostMapping("/meetings")
    public Meeting insertMeeting(@RequestBody Meeting meeting){
        return meetingService.insertMeeting(meeting);
    }

    @PutMapping("meeting/{meeting_id}")
    public Meeting updateMeeting(@RequestBody Meeting meeting) {
        return meetingService.updateMeeting(meeting);
    }

    @DeleteMapping("meeting/{meeting_id}")
    public boolean deleteMeeting(@PathVariable("meeting_id") Long meeting_id){
        return meetingService.deleteMeeting(meeting_id);
    }
}
