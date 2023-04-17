package com.enoca.enocaproject.repository;

import com.enoca.enocaproject.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
