package com.SpringBootWithSecurity.API.with.JWT.controller;

import com.SpringBootWithSecurity.API.with.JWT.model.Student;
import com.SpringBootWithSecurity.API.with.JWT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/insertStudents")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.insertStudents(student);
    }

    @GetMapping("/selectStudents")
    public List<Student> getStudents()
    {
        return studentService.selectStudents();
    }

    @PutMapping("/updateStudents")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudents(student);
    }

    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudentbyId(@PathVariable int id)
    {
        return studentService.deleteStudent(id);
    }

}
