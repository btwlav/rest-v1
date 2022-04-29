package com.vlad.rest.Resttest1.repos;

import com.vlad.rest.Resttest1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
