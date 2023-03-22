package com.revature.townhallbackend.repository;

import com.revature.townhallbackend.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(String status);
    @Query(value = "SELECT * FROM Complaint WHERE meeting_id = :meeting_id", nativeQuery = true)
    List<Complaint> findByMeetingId(@Param("meeting_id") Long meeting_id);



}
