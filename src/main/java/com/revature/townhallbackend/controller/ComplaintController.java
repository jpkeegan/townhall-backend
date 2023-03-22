package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintCreationException;
import com.revature.townhallbackend.exceptions.ComplaintExceptions.ComplaintNotFoundException;
import com.revature.townhallbackend.service.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    Logger logger = LoggerFactory.getLogger(ComplaintController.class);

    @PostMapping("/complaints")
    public ResponseEntity<Complaint> insertComplaint(@RequestBody Complaint complaint) throws ComplaintCreationException {
        logger.info("Adding complaint: " + complaint.toString());
        Complaint createdComplaint = complaintService.insertComplaint(complaint);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComplaint);
    }

    @PutMapping("/complaint/{complaint_id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable("complaint_id") Long complaint_id, @RequestBody Complaint complaint) throws ComplaintNotFoundException {
        Complaint existingComplaint = complaintService.getComplaintById(complaint_id);
        complaint.setComplaint_id(existingComplaint.getComplaint_id());
        Complaint updatedComplaint = complaintService.updateComplaint(complaint);
        logger.info("Updating complaint with id: " + complaint_id + " to: " + updatedComplaint);
        return ResponseEntity.ok(updatedComplaint);
    }

    @GetMapping("/complaint/id/{complaint_id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable("complaint_id") Long complaint_id) throws ComplaintNotFoundException {
        logger.info("Getting complaint with id: " + complaint_id);
        Complaint complaint = complaintService.getComplaintById(complaint_id);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/complaints")
    public List<Complaint> getAllComplaints() {
        logger.info("Getting all compalints");
        return complaintService.getAllComplaints();
    }

    @GetMapping("/complaints/{status}")
    public List<Complaint> getComplaintByStatus(@PathVariable("status")String status){
        logger.info("Getting complaints by status: " + status);
        return complaintService.getComplaintByStatus(status);
    }

    @GetMapping("/complaints/meetings/{meeting_id}")
    public ResponseEntity<List<Complaint>> getComplaintByMeetingId(@PathVariable("meeting_id") Long meeting_id) throws ComplaintNotFoundException {
        logger.info("Getting Complaint by Meeting Id: " + meeting_id);
        List<Complaint> complaints = complaintService.getComplaintByMeetingId(meeting_id);
        return ResponseEntity.ok(complaints);
    }

    @DeleteMapping("complaint/{complaint_id}")
    public boolean deleteComplaint(@PathVariable("complaint_id") Long complaint_id){
        logger.info("Deleting complaint with Id: " + complaint_id);
        return complaintService.deleteComplaint(complaint_id);
    }

}
