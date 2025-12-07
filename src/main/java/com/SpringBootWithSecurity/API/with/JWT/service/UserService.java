package com.SpringBootWithSecurity.API.with.JWT.service;

import com.SpringBootWithSecurity.API.with.JWT.model.Users;
import com.SpringBootWithSecurity.API.with.JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public Users saveUser(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        repo.save(users);
        return users;
    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate(
                new
                UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(users.getUsername());
        }
        return "Authentication Failed";

    }
}
