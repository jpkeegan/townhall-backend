package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintCreationException;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintNotFoundException;

import java.util.List;

public interface ComplaintService {
    Complaint insertComplaint(Complaint complaint) throws ComplaintCreationException;
    Complaint updateComplaint(Complaint complaint) throws ComplaintNotFoundException;
    Complaint getComplaintById(Long complaint_id) throws ComplaintNotFoundException;
    List<Complaint> getAllComplaints();
    List<Complaint> getComplaintByStatus(String status);
    List<Complaint> getComplaintByMeetingId(Long meeting_id) throws ComplaintNotFoundException;
    boolean deleteComplaint(Long complaint_id);

}
