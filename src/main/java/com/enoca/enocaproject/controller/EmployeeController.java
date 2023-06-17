package com.enoca.enocaproject.controller;

import com.enoca.enocaproject.business.EmployeeService;
import com.enoca.enocaproject.model.employee.EmployeeRequest;
import com.enoca.enocaproject.model.employee.EmployeeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<EmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/employees")
    public EmployeeRequest save(@RequestBody EmployeeRequest employeeRequest){
        System.out.println("deneme git hub");
        return  employeeService.save(employeeRequest);
    }

    @PostMapping("/update-employee")
    public EmployeeRequest update(@RequestBody EmployeeRequest employeeRequest){
        return  employeeService.update(employeeRequest);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id){
        this.employeeService.deleteEmployee(id);
    }
}
