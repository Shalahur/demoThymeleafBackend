package com.example.demoThymeleaf.service;

import com.example.demoThymeleaf.model.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void delete(Long id);
}
