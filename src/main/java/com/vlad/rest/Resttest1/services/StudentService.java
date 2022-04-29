package com.vlad.rest.Resttest1.services;

import com.vlad.rest.Resttest1.entities.Student;
import com.vlad.rest.Resttest1.repos.StudentRepo;
import com.vlad.rest.Resttest1.response.RestApiException;
import com.vlad.rest.Resttest1.response.RestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> list() {
        return studentRepo.findAll();
    }

    public void add(Student student) throws RestApiException {
        if (student.getName() == null) {
            throw new RestApiException("Field name cannot be empty!");
        }
        if (student.getBdate() == null) {
            throw new RestApiException("Field bdate cannot be empty!");
        }

        studentRepo.save(student);
    }

    public void delete(long id) throws RestApiException {
        if (studentRepo.findById(id).isEmpty()) {
            throw new RestApiException("Student with id "+ id +" is not present!");
        }
        studentRepo.deleteById(id);
    }

    public void update(Student student) {
        Optional<Student> row = studentRepo.findById(student.getId());
        if (row.isPresent()) {
            Student item = row.get();
            if (!student.getName().isEmpty()) {
                item.setName(student.getName());
            }
            if (student.getBdate() != null) {
                item.setBdate(student.getBdate());
            }
            studentRepo.save(item);
        }
    }

    public Student studentById(long id) throws RestApiException {
        Optional<Student> row = studentRepo.findById(id);
        if (row.isEmpty()) {
            throw new RestApiException("Student is not present!");
        }
        return row.get();
    }
}
