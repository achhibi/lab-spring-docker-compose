package amch.labs.spring.dockercompose.repository;

import amch.labs.spring.dockercompose.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
