package me.employeecrud.Controller;

import me.employeecrud.Entity.Employee;
import me.employeecrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/rest")
    public List<Employee> postman(){
        return employeeRepository.findAll();
    }
}
