package amch.labs.spring.dockercompose.resource;


import amch.labs.spring.dockercompose.jsonviews.EmployeeView;
import amch.labs.spring.dockercompose.model.Employee;
import amch.labs.spring.dockercompose.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Clock clock;

    @GetMapping
    @JsonView(EmployeeView.External.class)
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @JsonView(EmployeeView.Internal.class)
    @GetMapping("/internal")
    public Iterable<Employee> getAllEmployeesPublic() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }
}
