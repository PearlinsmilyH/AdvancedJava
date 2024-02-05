package net.javaguides.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;
@SpringBootTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Junit test for saveEmployee
    @Test
    @Order(1)
 //   @Rollback(value = false)
    public void saveEmployeeTest() {
        // Create an Employee object
        Employee employee = new Employee();
        employee.setFirstName("smily");
        employee.setLastName("Pearlin");
        employee.setEmail("smily@gmail.com");

        // Save the employee
        Employee savedEmployee = employeeRepository.save(employee);

        // Assert that the ID of the saved employee is greater than 0
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){
        // Retrieve the employee with ID 1
        Employee employee = employeeRepository.findById(2L).orElse(null);

        // Assert that the retrieved employee is not null and has the correct ID
        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(employee.getId()).isEqualTo(2L);
    }

    @Test
    @Order(3)
    public void getListOfEmployeeTest(){
        // Retrieve all employees
        List<Employee> employees = employeeRepository.findAll();

        // Assert that the list of employees is not empty
        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
 //   @Rollback(value = false)
    public void updateEmployeeTest(){
        // Retrieve the employee with ID 1
        Employee employee = employeeRepository.findById(3L).orElse(null);
        Assertions.assertThat(employee).isNotNull();

        // Update the email of the retrieved employee
        employee.setEmail("s@gmail.com");
        Employee updatedEmployee = employeeRepository.save(employee);

        // Assert that the email of the updated employee matches the new email
        Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo("s@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){
        // Retrieve the employee with ID 1
        Employee employee = employeeRepository.findById(2L).orElse(null);
        Assertions.assertThat(employee).isNotNull();

        // Delete the retrieved employee
        employeeRepository.delete(employee);

        // Verify that the employee has been deleted by attempting to retrieve it again
        Optional<Employee> optionalEmployee = employeeRepository.findById(2L);
        Assertions.assertThat(optionalEmployee).isEmpty();
    }
}
