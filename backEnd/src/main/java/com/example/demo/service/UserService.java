package com.example.demo.service;


import com.example.demo.Response.ResponseHandler;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> getUser(String email, String password){
         User user =  userRepository.findByEmail(email);
         if(user.getPassword().equals(password))
             return ResponseHandler.generateResponse("Login Success!", HttpStatus.OK, user);
         else
             return ResponseHandler.generateResponse("Incorrect Email or Password!", HttpStatus.BAD_REQUEST, null);
    }

    public ResponseEntity<Object> addUser(User newUser){
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());

        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return ResponseHandler.generateResponse("User Already exists!", HttpStatus.BAD_REQUEST, newUser);
            }
        }
        userRepository.save(newUser);
        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, newUser);
    }

    public ResponseEntity<Object> updateUser(User newUser){
        List<User> users = userRepository.findAll();
        System.out.println("Updated User: " + newUser.toString());

        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("Email or Username Already exists!");
                return ResponseHandler.generateResponse("User Already exists!", HttpStatus.BAD_REQUEST, newUser);
            }
        }
        userRepository.save(newUser);
        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, newUser);
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }
}
