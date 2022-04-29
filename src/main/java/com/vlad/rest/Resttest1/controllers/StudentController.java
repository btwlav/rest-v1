package com.vlad.rest.Resttest1.controllers;

import com.vlad.rest.Resttest1.entities.Student;
import com.vlad.rest.Resttest1.response.RestApiException;
import com.vlad.rest.Resttest1.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public List<Student> list() {
        return studentService.list();
    }

    @GetMapping("student/{id}")
    public Student student(@PathVariable("id") long id) throws RestApiException {
        return studentService.studentById(id);
    }

    @PostMapping("student")
    public List<Student> add(@RequestBody Student student) throws RestApiException {
        studentService.add(student);
        return studentService.list();
    }

    @DeleteMapping("student/{id}")
    public List<Student> delete(@PathVariable("id") long id) throws RestApiException {
        studentService.delete(id);
        return studentService.list();
    }

    @PutMapping("student")
    public List<Student> update(@RequestBody Student student) {
        studentService.update(student);
        return studentService.list();
    }
}
