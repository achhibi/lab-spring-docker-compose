package amch.labs.spring.dockercompose;

import amch.labs.spring.dockercompose.model.Employee;
import amch.labs.spring.dockercompose.repository.EmployeeRepository;
import amch.labs.spring.dockercompose.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LabsSpringDockerComposeApplicationTests.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private Clock clock;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        var fixedZone =  ZoneId.of("UTC");
        var fixedInstant = Instant.parse("2024-06-21T10:00:00Z");
        var fixedClock = Clock.fixed(fixedInstant, fixedZone);
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedZone);
    }

    @Test
    public void testCreateEmployee() {

        Employee employee = new Employee();
        employee.setFirstName("Amor");
        employee.setLastName("CH");

        when(employeeRepository.save(employee)).thenAnswer(invocation -> {
            Employee savedEmployee = invocation.getArgument(0);
            savedEmployee.setId(1L);
            return savedEmployee;
        });

        Employee createdEmployee = employeeService.createEmployee(employee);

        assertEquals(1L, createdEmployee.getId());
        assertEquals(LocalDateTime.of(2024, 6, 21, 10, 0), createdEmployee.getCreatedAt());
        assertEquals(LocalDateTime.of(2024, 6, 21, 10, 0), createdEmployee.getUpdatedAt());
    }
}