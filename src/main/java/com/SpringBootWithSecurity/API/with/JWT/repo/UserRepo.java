package com.SpringBootWithSecurity.API.with.JWT.repo;

import com.SpringBootWithSecurity.API.with.JWT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String name);
}
