package com.revature.townhallbackend.repository;

import com.revature.townhallbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    List<User> findByRole(String role);
}
