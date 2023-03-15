package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.ComplaintStatus;
import com.revature.townhallbackend.entity.Meeting;
import com.revature.townhallbackend.entity.User;

import java.util.List;

public interface ComplaintService {
    Complaint insertComplaint(Complaint complaint);
    Complaint updateComplaint(Complaint complaint);
    Complaint getComplaintById(Long complaint_id);
    List<Complaint> getAllComplaints();
    List<Complaint> getComplaintByStatus(String status);
    boolean deleteComplaint(Long complaint_id);

}
