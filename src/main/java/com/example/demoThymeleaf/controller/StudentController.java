package com.example.demoThymeleaf.controller;

import com.example.demoThymeleaf.model.Student;
import com.example.demoThymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    public static final String PATH_VAR_ID = "{id}";

    public static final String BASE_ROUTE = "/student";
    public static final String INDEX_ROUTE = BASE_ROUTE + "/home";
    public static final String ADD_ROUTE = BASE_ROUTE + "/add";
    public static final String EDIT_ROUTE = BASE_ROUTE + "/edit/" + PATH_VAR_ID;
    public static final String DELETE_ROUTE = BASE_ROUTE + "/delete/" + PATH_VAR_ID;

    @Autowired
    StudentService studentService;

    @GetMapping(BASE_ROUTE)
    public List<Student> index() {
        return studentService.findAll();
    }

    @PostMapping(ADD_ROUTE)
    public Student createUser(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping(DELETE_ROUTE)
    public ResponseEntity<Student> deleteUser(@PathVariable("id") long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
