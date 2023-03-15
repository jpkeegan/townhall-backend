package com.revature.townhallbackend;

import com.revature.townhallbackend.entity.Complaint;
import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.repository.UserRepository;
import com.revature.townhallbackend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserTest{

    @MockBean(UserRepository.class)
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void testFindUser(){
        User expectedUser = new User(
                12L,
                "TestUsername",
                "TestPassword",
                "test",
                "test",
                "test"
        );
        Mockito.when(userRepository
                .findByUsernameAndPassword("TestUsername", "TestPassword"))
                .thenReturn(expectedUser);

        Assertions.assertEquals(expectedUser, userService
                .getUserInfo("TestUsername", "TestPassword"));

    }

    @Test
    public void testFindByRole(){
        List<User> users = new ArrayList<>();
        User test1 = new User("jHalpert","pass123","Jim","Halpert", "COUNCIL");
        users.add(test1);
        User test2 = new User("dSchrute", "pass123","Dwight", "Schrute", "CONSTITUENT");

        List<User> expectedUser = Arrays.asList(
                new User("dSchrute", "pass123","Dwight", "Schrute", "CONSTITUENT"));
        Mockito.when(userRepository
                .findByRole("CONSTITUENT")).thenReturn((List<User>) expectedUser);
        Assertions.assertEquals(expectedUser, userService
                .getUsersByRole("CONSTITUENT"));

    }
}



