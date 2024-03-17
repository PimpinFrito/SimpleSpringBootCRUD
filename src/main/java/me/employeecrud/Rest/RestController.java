package me.employeecrud.Rest;

import jakarta.annotation.PostConstruct;
import me.employeecrud.Entity.Employee;
import me.employeecrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void postStruct(){
        System.out.println("Post Construct is working!");
    }
    @GetMapping({"/employee","/list"})
    public List<Employee> postman(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Object getEmployee(@PathVariable Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) throw new EmployeeNotFoundException("Employee Id not found in db");

        return employee.get();//employee.orElseGet(Employee::new);
    }
}