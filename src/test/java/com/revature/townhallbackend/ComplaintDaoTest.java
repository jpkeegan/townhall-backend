package com.revature.townhallbackend;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintNotFoundException;
import com.revature.townhallbackend.repository.ComplaintRepository;
import com.revature.townhallbackend.repository.MeetingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class ComplaintDaoTest {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void testFindByStatus() {
        Meeting meeting = new Meeting(1L, "title", "test address", 10L, "test summary");
        meetingRepository.save(meeting);

        Complaint test1 = new Complaint("test", "test1", "PENDING", meeting.getMeeting_id());
        complaintRepository.save(test1);
        Complaint test2 = new Complaint("test", "test2", "UNRESOLVED", meeting.getMeeting_id());
        complaintRepository.save(test2);

        List<Complaint> complaints = complaintRepository.findByStatus("UNRESOLVED");
        Assertions.assertEquals(Collections.singletonList(test2), complaints);
    }

//    @Test
//    public void testFindByMeetingId() {
//        Meeting meeting = new Meeting(1L, "title", "test address", 10L, "test summary");
//        meetingRepository.save(meeting);
//
//        Complaint test1 = new Complaint("test", "test1", "PENDING", meeting.getMeeting_id());
//        complaintRepository.save(test1);
//        Complaint test2 = new Complaint("test", "test2", "IGNORED", meeting.getMeeting_id());
//        complaintRepository.save(test2);
//
//        List<Complaint> complaints = complaintRepository.findByMeetingId(meeting.getMeeting_id());
//        Assertions.assertEquals(2, complaints.size());
//        Assertions.assertTrue(complaints.contains(test1));
//        Assertions.assertTrue(complaints.contains(test2));
//    }
}
