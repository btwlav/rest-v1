package com.vlad.rest.Resttest1.config;

import com.vlad.rest.Resttest1.entities.Student;
import com.vlad.rest.Resttest1.repos.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
        return args -> studentRepo.saveAll(List.of(
                new Student("Vlad", LocalDate.of(2003, Month.JANUARY, 6)),
                new Student("test", LocalDate.of(2000, Month.JANUARY, 1))
        ));
    }
}
