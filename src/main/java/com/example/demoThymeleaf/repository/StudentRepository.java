package com.example.demoThymeleaf.repository;

import com.example.demoThymeleaf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
