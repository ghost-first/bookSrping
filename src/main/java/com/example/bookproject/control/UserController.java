package com.example.bookproject.control;

import com.example.bookproject.entity.User;
import com.example.bookproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        User u = null;
        try {
            u = userRepository.findById(user.getNumber()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        System.out.println(user);
        System.out.println(u);
        if (u.getPassword().equals(user.getPassword())){
            return u;
        }else{
            return null;
        }
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setNumber(userRepository.findMax() + 1);
//        user.setUsername("试验品");
//        user.setPassword("111");
        user.setRole(0);
        User user1 = userRepository.save(user);
        System.out.println(user1);
        return user1;
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        User user1 = userRepository.save(user);
        System.out.println(user1);
        return user1;
    }

}
