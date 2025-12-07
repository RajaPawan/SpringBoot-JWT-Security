package com.SpringBootWithSecurity.API.with.JWT.controller;

import com.SpringBootWithSecurity.API.with.JWT.model.Users;
import com.SpringBootWithSecurity.API.with.JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users)
    {
        return userService.saveUser(users);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users users)
    {
        return userService.verify(users);
    }
}
