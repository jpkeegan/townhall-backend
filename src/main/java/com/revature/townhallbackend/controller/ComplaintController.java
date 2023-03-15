package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.ComplaintStatus;
import com.revature.townhallbackend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @PostMapping("/complaints")
    public Complaint insertComplaint(@RequestBody Complaint complaint){return complaintService.insertComplaint(complaint);}

    @PutMapping("/complaint/{complaint_id}")
    public Complaint updateComplaint(@RequestBody Complaint complaint){return complaintService.updateComplaint(complaint);}

    @GetMapping("/complaint/id/{complaint_id}")
    public Complaint getComplaintById(@PathVariable("complaint_id") Long complaint_id){
        return complaintService.getComplaintById(complaint_id);
    }

    @GetMapping("/complaints")
    public List<Complaint> getAllComplaints() {return complaintService.getAllComplaints();}

    @GetMapping("/complaints/{status}")
    public List<Complaint> getComplaintByStatus(@PathVariable("status")String status){
        return complaintService.getComplaintByStatus(status);
    }

    @DeleteMapping("complaint/{complaint_id}")
    public boolean deleteComplaint(@PathVariable("complaint_id") Long complaint_id){
        return complaintService.deleteComplaint(complaint_id);
    }

}
