package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserInfo(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);}

    @Override
    public List<User> getUsersByRole(String role){return userRepository.findByRole(role);}

    @Override
    public User insertUser(User user){ return userRepository.save(user);}

    @Override
    public User updateUser(User user){return userRepository.save(user);}

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}


}
