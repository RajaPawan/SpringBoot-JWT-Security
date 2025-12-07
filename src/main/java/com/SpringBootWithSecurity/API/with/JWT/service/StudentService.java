package com.SpringBootWithSecurity.API.with.JWT.service;

import com.SpringBootWithSecurity.API.with.JWT.model.Student;
import com.SpringBootWithSecurity.API.with.JWT.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public Student insertStudents(Student student) {
        repo.save(student);
        return student;
    }

    public List<Student> selectStudents() {
        return repo.findAll();
    }

    public Student updateStudents(Student student) {
        return repo.save(student);
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return " Student with id: "+id+" deleted successfully.";
    }
}
