package com.revature.townhallbackend;

import com.revature.townhallbackend.entity.User;
import com.revature.townhallbackend.exceptions.UserExceptions.InvalidUserCredentialsException;
import com.revature.townhallbackend.repository.UserRepository;
import com.revature.townhallbackend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class UserDaoTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindUser() throws InvalidUserCredentialsException {
        User expectedUser = new User(
                "TestUsername",
                "TestPassword",
                "test",
                "test",
                "test",
                "test"
        );
        userRepository.save(expectedUser);

        User retrievedUser = userRepository.findByUsernameAndPassword("TestUsername", "TestPassword");
        Assertions.assertEquals(expectedUser, retrievedUser);
    }

    @Test
    public void testFindByRole(){
        User test1 = new User("jHalpert","pass123","Jim","Halpert", "COUNCIL", "test");
        userRepository.save(test1);
        User test2 = new User("dSchrute", "pass123","Dwight", "Schrute", "CONSTITUENT", "test");
        userRepository.save(test2);

        List<User> expectedUser = userRepository.findByRole("CONSTITUENT");
        Assertions.assertEquals(expectedUser, Collections.singletonList(test2));
    }
}



