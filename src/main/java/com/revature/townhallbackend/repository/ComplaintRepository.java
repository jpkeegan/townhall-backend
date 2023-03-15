package com.revature.townhallbackend.repository;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(String status);
}
