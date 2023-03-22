package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.exceptions.UserExceptions.InvalidUserCredentialsException;
import com.revature.townhallbackend.exceptions.UserExceptions.UserCreationException;

import java.util.List;

public interface UserService {
    User getUserInfo(String username, String password) throws InvalidUserCredentialsException;

    List<User> getUsersByRole(String role);
    User insertUser(User user) throws UserCreationException;

    User updateUser(User user);

    List<User> getAllUsers();

    boolean deleteUser(Long user_id);
}
