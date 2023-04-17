package com.enoca.enocaproject.model.employee;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String description;
}

