package com.enoca.enocaproject.model.employee;

import com.enoca.enocaproject.model.textile.Textile;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EmployeeRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String description;
    private Textile textile;

}
