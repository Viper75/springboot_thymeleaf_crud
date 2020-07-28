package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(long id, Employee employee) {
        Employee savedEmployee = getEmployeeById(id);
        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastName(employee.getLastName());
        savedEmployee.setEmail(employee.getEmail());
        employeeRepository.save(savedEmployee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.getOne(id);
    }

    public void deleteEmployee(long id) {
        employeeRepository.delete(getEmployeeById(id));
    }
}
