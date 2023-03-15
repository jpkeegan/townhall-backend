package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.User;

import java.util.List;

public interface UserService {
    User getUserInfo(String username, String password);

    List<User> getUsersByRole(String role);
    User insertUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();
}
