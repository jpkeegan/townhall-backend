package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Login;
import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.exceptions.UserExceptions.InvalidUserCredentialsException;
import com.revature.townhallbackend.exceptions.UserExceptions.UserCreationException;
import com.revature.townhallbackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger1 = LoggerFactory.getLogger(UserController.class);

    @PatchMapping("/login")
    public ResponseEntity<User> getUserInfo(@RequestBody Login login) throws InvalidUserCredentialsException {
        logger1.info("Logging in with: " + login.toString());
        User user = userService.getUserInfo(login.getUsername(), login.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("users/{role}")
    public List<User> getByRole(@PathVariable("role") String role){
        logger1.info("Get all users with role: " + role);
        return userService.getUsersByRole(role);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        logger1.info("Getting all users");
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> insertUser(@RequestBody User user) throws UserCreationException {
        logger1.info("Adding user: " + user.toString());
        User createdUser = userService.insertUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("user/{user_id}")
    public User updateUser(@RequestBody User user) {
        logger1.info("Updating user:" + user.toString());
        return userService.updateUser(user);
    }

    @DeleteMapping("user/{user_id}")
    public boolean deleteUser(@PathVariable("user_id") Long user_id){
        logger1.info("Deleting user with Id: " + user_id);
        return userService.deleteUser(user_id);
    }

}
