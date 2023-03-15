package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Meeting;

import java.util.List;

public interface MeetingService {
    List<Meeting> getAllMeetings();
    Meeting getMeetingById(Long meeting_id);
    Meeting insertMeeting(Meeting meeting);
    Meeting updateMeeting(Meeting meeting);
    boolean deleteMeeting(Long meeting_id);
}
