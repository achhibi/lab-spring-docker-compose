package amch.labs.spring.dockercompose.service;

import amch.labs.spring.dockercompose.model.Employee;
import amch.labs.spring.dockercompose.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(LocalDateTime.now(clock));
        employee.setUpdatedAt(LocalDateTime.now(clock));
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        employee.setUpdatedAt(LocalDateTime.now(clock));
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}