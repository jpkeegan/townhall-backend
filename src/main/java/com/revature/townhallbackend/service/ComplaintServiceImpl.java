package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintCreationException;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintNotFoundException;
import com.revature.townhallbackend.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;



    @Override
    public Complaint insertComplaint(Complaint complaint) throws ComplaintCreationException {
        complaint.setStatus("PENDING");
        Complaint createdComplaint = complaintRepository.save(complaint);
        if(createdComplaint == null){
            throw new ComplaintCreationException();
        }
        return createdComplaint;
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) throws ComplaintNotFoundException {
        Optional<Complaint> complaintOptional = complaintRepository.findById(complaint.getComplaint_id());
        if (complaintOptional.isPresent()) {
            Complaint existingComplaint = complaintOptional.get();

            existingComplaint.setTitle(complaint.getTitle());
            existingComplaint.setDescription(complaint.getDescription());
            existingComplaint.setStatus(complaint.getStatus());
            existingComplaint.setMeeting_id(complaint.getMeeting_id());

            return complaintRepository.save(existingComplaint);
        } else {
            throw new ComplaintNotFoundException();
        }
    }


    @Override
    public Complaint getComplaintById(Long complaint_id) throws ComplaintNotFoundException {
        Optional<Complaint> complaintOptional = complaintRepository.findById(complaint_id);
        if (complaintOptional.isPresent()) {
            return complaintOptional.get();
        } else {
            throw new ComplaintNotFoundException();
        }
    }

    @Override
    public List<Complaint> getComplaintByStatus(String status) {return complaintRepository.findByStatus(status);}

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintByMeetingId(Long meeting_id) throws ComplaintNotFoundException {
        List<Complaint> complaints = complaintRepository.findByMeetingId(meeting_id);
        if (complaints.isEmpty()) {
            throw new ComplaintNotFoundException();
        }
        return complaints;
    }

    @Override
    public boolean deleteComplaint(Long complaint_id){
        boolean found = complaintRepository.existsById(complaint_id);
        complaintRepository.deleteById(complaint_id);
        return found;
    }


}
