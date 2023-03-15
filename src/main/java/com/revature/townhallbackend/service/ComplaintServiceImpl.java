package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.ComplaintStatus;
import com.revature.townhallbackend.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;



    @Override
    public Complaint insertComplaint(Complaint complaint) {
        complaint.setStatus("PENDING");
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getComplaintById(Long complaint_id) { return complaintRepository.findById(complaint_id).get();}

    @Override
    public List<Complaint> getComplaintByStatus(String status) {return complaintRepository.findByStatus(status);}

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public boolean deleteComplaint(Long complaint_id){
        boolean found = complaintRepository.existsById(complaint_id);
        complaintRepository.deleteById(complaint_id);
        return found;
    }
}
