package com.example.demoThymeleaf.form;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder", toBuilder = true)
public class StudentForm {
    private Long id;
    private String name;
    private String fatherName;
    private String motherName;
}
