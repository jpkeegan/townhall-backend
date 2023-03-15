package com.revature.townhallbackend.repository;

import com.revature.townhallbackend.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
