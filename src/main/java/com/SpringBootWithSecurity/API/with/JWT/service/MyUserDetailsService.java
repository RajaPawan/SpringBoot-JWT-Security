package com.SpringBootWithSecurity.API.with.JWT.service;

import com.SpringBootWithSecurity.API.with.JWT.model.UserPrincipal;
import com.SpringBootWithSecurity.API.with.JWT.model.Users;
import com.SpringBootWithSecurity.API.with.JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = repo.findByUsername(username);
        if(users==null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        // ⭐ 1. Check if password not encrypted
        if (!users.getPassword().startsWith("$2")) {
            // ⭐ 2. Encode
            String encoded = passwordEncoder.encode(users.getPassword());
            users.setPassword(encoded);
            // ⭐ 3. Save back to DB
            repo.save(users);
        }
        return new UserPrincipal(users);
    }
}
