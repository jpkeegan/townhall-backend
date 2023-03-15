package com.revature.townhallbackend.controller;

import com.revature.townhallbackend.entity.Login;
import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PatchMapping("/login")
    public ResponseEntity<User> getUserInfo(@RequestBody Login login){
        User user = userService.getUserInfo(login.getUsername(), login.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("users/{role}")
    public List<User> getByRole(@PathVariable("role") String role){
        return userService.getUsersByRole(role);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){return userService.getAllUsers();}

    @PostMapping("/users")
    public User insertUser(@RequestBody User user){ return userService.insertUser(user);}

    @PutMapping("user/{user_id}")
    public User updateUser(@RequestBody User user) {return userService.updateUser(user);}

}
