package com.vlad.rest.Resttest1.services;

import com.vlad.rest.Resttest1.entities.Student;
import com.vlad.rest.Resttest1.repos.StudentRepo;
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

    public void add(Student student) {
        studentRepo.save(student);
    }

    public void delete(long id) {
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
}
