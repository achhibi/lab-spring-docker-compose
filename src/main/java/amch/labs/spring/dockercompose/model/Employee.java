package amch.labs.spring.dockercompose.model;

import amch.labs.spring.dockercompose.jsonviews.EmployeeView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonView(EmployeeView.External.class)
    private String firstName;
    @JsonView(EmployeeView.External.class)
    private String lastName;
    @JsonView(EmployeeView.Internal.class)
    private String email;
    @JsonView(EmployeeView.Internal.class)
    private String phone;
    @JsonView(EmployeeView.Excluded.class)
    private LocalDateTime createdAt;
    @JsonView(EmployeeView.Excluded.class)
    private LocalDateTime updatedAt;
    public Employee() {}

}
