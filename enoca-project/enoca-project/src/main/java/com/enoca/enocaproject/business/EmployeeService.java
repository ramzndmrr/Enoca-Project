package com.enoca.enocaproject.business;

import com.enoca.enocaproject.core.mappers.ModelMapperService;
import com.enoca.enocaproject.model.employee.Employee;
import com.enoca.enocaproject.model.employee.EmployeeRequest;
import com.enoca.enocaproject.model.employee.EmployeeResponse;
import com.enoca.enocaproject.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapperService modelMapperService){
        this.employeeRepository = employeeRepository;
        this.modelMapperService = modelMapperService;

    }

    public List<EmployeeResponse> getAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponseList = employeeList
                .stream()
                .map(employee -> this.modelMapperService.forResponse().map(employee,EmployeeResponse.class))
                .collect(Collectors.toList());
        return employeeResponseList;
    }

    public EmployeeRequest save(EmployeeRequest employeeRequest){
        Employee employee = this.modelMapperService.forRequest().map(employeeRequest,Employee.class);
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeRequest empReq = this.modelMapperService.forResponse().map(saveEmployee,EmployeeRequest.class);
        return empReq;
    }
    public EmployeeRequest update(EmployeeRequest employeeRequest){
        Employee savedEmployee = employeeRepository.findById(employeeRequest.getId()).orElseThrow();
        employeeRepository.save(savedEmployee);
        EmployeeRequest empReq=this.modelMapperService.forResponse().map(savedEmployee,EmployeeRequest.class);
        return empReq;
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
