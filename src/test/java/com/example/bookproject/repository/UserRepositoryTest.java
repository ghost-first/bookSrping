package com.example.bookproject.repository;

import com.example.bookproject.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findById(){
        User user = userRepository.findById(1200).get();
        System.out.println(user);
    }

    @Test
    public void findByWrong(){
        User user = userRepository.findById(110).get();
        System.out.println(user);
    }

    @Test
    public void register(){
        User user = new User();
        user.setNumber(userRepository.findMax() + 1);
        user.setUsername("试验品");
        user.setPassword("111");
        user.setRole(0);
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void findMax(){
        Integer max = userRepository.findMax();
        System.out.println(max);
    }

}