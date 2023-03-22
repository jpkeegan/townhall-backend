package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingCreationException;
import com.revature.townhallbackend.exceptions.MeetingExceptions.MeetingNotFoundException;
import com.revature.townhallbackend.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeetingById(Long meeting_id) throws MeetingNotFoundException {
        Optional<Meeting> meetingOptional = meetingRepository.findById(meeting_id);
        if (meetingOptional.isPresent()) {
            return meetingOptional.get();
        } else {
            throw new MeetingNotFoundException();
        }
    }

    @Override
    public Meeting insertMeeting(Meeting meeting) throws MeetingCreationException{
        Meeting createdMeeting = meetingRepository.save(meeting);
        if(createdMeeting == null){
            throw new MeetingCreationException();
        }
        return createdMeeting;
    }

    @Override
    public Meeting updateMeeting(Meeting meeting) throws MeetingNotFoundException {
        Optional<Meeting> meetingOptional = meetingRepository.findById(meeting.getMeeting_id());
        if (meetingOptional.isPresent()) {
            return meetingRepository.save(meeting);
        } else {
            throw new MeetingNotFoundException();
        }
    }

    @Override
    public boolean deleteMeeting(Long meeting_id) {
        boolean found = meetingRepository.existsById(meeting_id);
        meetingRepository.deleteById(meeting_id);
        return found;
    }
}

