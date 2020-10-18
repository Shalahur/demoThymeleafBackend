package com.example.demoThymeleaf.service.impl;

import com.example.demoThymeleaf.exception.ResourceNotFoundException;
import com.example.demoThymeleaf.form.StudentForm;
import com.example.demoThymeleaf.model.Student;
import com.example.demoThymeleaf.repository.StudentRepository;
import com.example.demoThymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student studentInfo) {
        Student student = null;
        if (Objects.nonNull(studentInfo.getId())) {
            student = studentRepository.findById(studentInfo.getId()).orElse(null);
        }

        if (Objects.isNull(student)) {
            student = studentRepository.save(Student.builder()
                    .name(studentInfo.getName())
                    .fatherName(studentInfo.getFatherName())
                    .motherName(studentInfo.getMotherName())
                    .build());
        }

        return student;
    }

    @Override
    public Student findById(Long id) {
        Objects.requireNonNull(id);
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Objects.requireNonNull(id);
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }
}
