package com.enoca.enocaproject.model.textile;

import com.enoca.enocaproject.model.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
public class TextileRequest {
    private long id;
    private String name;
    private String address;
}
