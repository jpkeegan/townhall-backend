package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingCreationException;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingNotFoundException;

import java.util.List;

public interface MeetingService {
    List<Meeting> getAllMeetings();
    Meeting getMeetingById(Long meeting_id) throws MeetingNotFoundException;
    Meeting insertMeeting(Meeting meeting) throws MeetingCreationException;
    Meeting updateMeeting(Meeting meeting) throws MeetingNotFoundException;
    boolean deleteMeeting(Long meeting_id);
}
