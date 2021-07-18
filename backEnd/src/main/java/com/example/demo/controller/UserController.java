package com.example.demo.controller;

import com.example.demo.model.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.UserService;
import com.example.demo.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> Login(@RequestHeader("Authorization") long authId){
        return userService.getUserById(authId);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Long Login(@RequestBody Map<String,Object> payload){
        String email = payload.get("email").toString();
        String password = payload.get("password").toString();
        return userService.getUser(email,password);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    private User updateUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

}
