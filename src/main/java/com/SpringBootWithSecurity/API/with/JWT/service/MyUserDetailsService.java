package com.SpringBootWithSecurity.API.with.JWT.service;

import com.SpringBootWithSecurity.API.with.JWT.model.UserPrincipal;
import com.SpringBootWithSecurity.API.with.JWT.model.Users;
import com.SpringBootWithSecurity.API.with.JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = repo.findByUsername(username);
        if(users==null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(users);
    }
}
