package com.SpringBootWithSecurity.API.with.JWT.repo;

import com.SpringBootWithSecurity.API.with.JWT.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
