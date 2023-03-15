package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeetingById(Long meeting_id) {return meetingRepository.findById(meeting_id).get();}

    @Override
    public Meeting insertMeeting(Meeting meeting) {return meetingRepository.save(meeting);}

    @Override
    public Meeting updateMeeting(Meeting meeting) {return meetingRepository.save(meeting);}

    @Override
    public boolean deleteMeeting(Long meeting_id) {
        boolean found = meetingRepository.existsById(meeting_id);
        meetingRepository.deleteById(meeting_id);
        return found;
    }
}

