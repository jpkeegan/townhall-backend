package com.revature.townhallbackend.service;

import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.exceptions.UserExceptions.InvalidUserCredentialsException;
import com.revature.townhallbackend.exceptions.UserExceptions.UserCreationException;
import com.revature.townhallbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserInfo(String username, String password) throws InvalidUserCredentialsException {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            throw new InvalidUserCredentialsException();
        }
        return user;
    }

    @Override
    public List<User> getUsersByRole(String role){return userRepository.findByRole(role);}

    @Override
    public User insertUser(User user) throws UserCreationException {
        User createdUser = userRepository.save(user);
        if(createdUser == null){
            throw new UserCreationException();
        }
        return createdUser;
    }

    @Override
    public User updateUser(User user){return userRepository.save(user);}

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}

    @Override
    public boolean deleteUser(Long user_id) {
        boolean found = userRepository.existsById(user_id);
        userRepository.deleteById(user_id);
        return found;
    }


}
