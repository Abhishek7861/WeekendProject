package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public long getUser(String email, String password){
         User u =  userRepository.findByEmail(email);
         if(u.getPassword().equals(password))
             return u.getId();
         else
             return 0;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }
}
